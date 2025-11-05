package com.example.game.units;

import com.example.game.core.Point2D;
import com.example.game.core.Unit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuttle extends Unit implements Transporter {
    private final int capacity = 8;
    private final List<Unit> passengers = new ArrayList<>();

    public Shuttle(int id, Point2D startPos) {
        super("셔틀", id, true, startPos);
    }

    @Override
    public int getCapacity() { return capacity; }

    @Override
    public int getPassengerCount() { return passengers.size(); }

    @Override
    public boolean board(Unit u) {
        if (u == null) return false;
        if (passengers.size() >= capacity) {
            log("탑승 실패: 정원 초과입니다. (" + u.getDisplayName() + ")");
            return false;
        }
        // Knight/Archer만 탑승 가능
        if (!(u instanceof Knight) && !(u instanceof Archer)) {
            log("탑승 실패: " + u.getDisplayName() + " 는 탑승할 수 없습니다.");
            return false;
        }
        passengers.add(u);
        log(u.getDisplayName() + " 탑승 완료. (현재 " + passengers.size() + "/" + capacity + ")");
        // 탑승 즉시 좌표 동기화
        setUnitPositionSilently(u, this.position);
        return true;
    }

    @Override
    public List<Unit> unloadAll() {
        if (passengers.isEmpty()) {
            log("하차할 승객이 없습니다.");
            return Collections.emptyList();
        }
        List<Unit> out = new ArrayList<>(passengers);
        for (Unit u : out) {
            setUnitPositionSilently(u, this.position);
            log(u.getDisplayName() + " 하차합니다. (좌표 " + this.position + ")");
        }
        passengers.clear();
        return out;
    }

    @Override
    public void moveTo(Point2D dest) {
        log("날아서 " + position + " -> " + dest + " 로 이동합니다. (승객 " + passengers.size() + "명)");
        this.position = dest;
        // 승객 좌표도 동기화
        for (Unit u : passengers) {
            setUnitPositionSilently(u, dest);
        }
    }

    @Override
    protected boolean canAttack(Unit target) {
        // 셔틀은 공격 불가
        return false;
    }

    private static void setUnitPositionSilently(Unit u, Point2D p) {
        try {
            Field f = Unit.class.getDeclaredField("position");
            f.setAccessible(true);
            f.set(u, p);
        } catch (Exception ignored) { }
    }
}
