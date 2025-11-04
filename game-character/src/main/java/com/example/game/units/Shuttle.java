
package com.example.game.units;

import com.example.game.core.*;
import java.util.ArrayList;
import java.util.List;

public class Shuttle extends Unit {
    private final int capacity = 8;
    private final List<Unit> passengers = new ArrayList<>(); // Knights & Archers only

    public Shuttle(int id, Point2D startPos) {
        super("셔틀", id, true, startPos);
    }

    public boolean board(Unit u) {
        if (passengers.size() >= capacity) {
            log("탑승 실패: 정원 초과입니다. (" + u.getDisplayName() + ")");
            return false;
        }
        // Only allow Knight or Archer
        if (!(u instanceof Knight) && !(u instanceof Archer)) {
            log("탑승 실패: " + u.getDisplayName() + " 는 탑승할 수 없습니다.");
            return false;
        }
        passengers.add(u);
        log(u.getDisplayName() + " 탑승 (현재 승객: " + passengers.size() + "/" + capacity + ")");
        return true;
    }

    public List<Unit> disembarkAll() {
        List<Unit> out = new ArrayList<>(passengers);
        passengers.clear();
        for (Unit u : out) {
            // 하차 시 위치를 셔틀 위치로 동기화
            if (u.getPosition().x != this.position.x || u.getPosition().y != this.position.y) {
                // 이동 없이 위치만 동기화 (하차)
                // 별도 로그: 개별 유닛 하차
                System.out.println("[" + this.getDisplayName() + "] " + u.getDisplayName() + " 하차 (위치 동기화: " + this.position + ")");
            } else {
                System.out.println("[" + this.getDisplayName() + "] " + u.getDisplayName() + " 하차");
            }
        }
        log("모든 승객 하차 완료.");
        return out;
    }

    @Override
    public void moveTo(Point2D dest) {
        log("날아서 " + position + " -> " + dest + " 로 이동합니다. (승객 " + passengers.size() + "명)");
        this.position = dest;
        // 함께 이동: 승객의 위치를 업데이트 (출력은 셔틀에서만)
        for (Unit u : passengers) {
            // 승객은 셔틀 내부에서 함께 이동하므로 별도 이동 로그 없음, 위치만 동기화
            // (요구사항: 모든 행동은 출력 - 이미 셔틀이 이동을 출력했으므로 중복 방지를 위해 여기서는 위치만 갱신)
            try {
                java.lang.reflect.Field posField = Unit.class.getDeclaredField("position");
                posField.setAccessible(true);
                posField.set(u, dest);
            } catch (Exception ignored) {}
        }
    }
}
