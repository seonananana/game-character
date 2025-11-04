
package com.example.game.units;

import com.example.game.core.*;

public class Griffin extends Unit implements Attackable {

    public Griffin(int id, Point2D startPos) {
        super("그리핀", id, true, startPos);
    }

    @Override
    public void moveTo(Point2D dest) {
        log("하늘을 날아 " + position + " -> " + dest + " 로 이동합니다.");
        this.position = dest;
    }

    @Override
    public boolean canAttack(Unit target) {
        // Griffin cannot attack flying targets; strikes ground with lightning
        return !target.isFlying();
    }

    @Override
    public void attack(Unit target) {
        if (!canAttack(target)) {
            log("공격 불가: 날아다니는 유닛은 천둥 번개로 공격할 수 없습니다. (" + target.getDisplayName() + ")");
            return;
        }
        log("하늘에서 번개를 내려 " + target.getDisplayName() + " 를 타격합니다!");
    }
}
