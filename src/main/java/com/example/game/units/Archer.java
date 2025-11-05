package com.example.game.units;

import com.example.game.core.Point2D;
import com.example.game.core.Unit;

public class Archer extends Unit {
    public Archer(int id, Point2D startPos) {
        super("궁수", id, false, startPos);
    }

    @Override
    public void moveTo(Point2D dest) {
        log("걸어서 " + position + " -> " + dest + " 로 이동합니다. (느리게)");
        this.position = dest;
    }

    @Override
    protected boolean canAttack(Unit target) {
        // 궁수는 "공중/지상 모두 공격 가능"
        return true;
    }
}
