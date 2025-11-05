package com.example.game.units;

import com.example.game.core.Point2D;
import com.example.game.core.Unit;

public class Knight extends Unit {
    public Knight(int id, Point2D startPos) {
        super("기사", id, false, startPos);
    }

    @Override
    public void moveTo(Point2D dest) {
        log("말을 타고 " + position + " -> " + dest + " 로 이동합니다.");
        this.position = dest;
    }

    @Override
    protected boolean canAttack(Unit target) {
        // 기사는 "비행 유닛을 공격할 수 없음"
        return !target.isFlying();
    }
}
