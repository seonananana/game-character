package com.example.game.units;

import com.example.game.core.Point2D;
import com.example.game.core.Unit;

public class Griffin extends Unit {
    public Griffin(int id, Point2D startPos) {
        super("그리핀", id, true, startPos);
    }

    @Override
    public void moveTo(Point2D dest) {
        log("날아서 " + position + " -> " + dest + " 로 이동합니다.");
        this.position = dest;
    }

    @Override
    protected boolean canAttack(Unit target) {
        // 그리핀은 "지상 유닛만 공격 가능"
        return !target.isFlying();
    }
}
