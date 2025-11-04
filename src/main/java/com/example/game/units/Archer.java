
package com.example.game.units;

import com.example.game.core.*;

public class Archer extends Unit implements Attackable {

    public Archer(int id, Point2D startPos) {
        super("궁수", id, false, startPos);
    }

    @Override
    public void moveTo(Point2D dest) {
        log("걸어서 " + position + " -> " + dest + " 로 이동합니다. (기사보다 느림)");
        this.position = dest;
    }

    @Override
    public boolean canAttack(Unit target) {
        // Archer can attack all targets (ground and air)
        return true;
    }

    @Override
    public void attack(Unit target) {
        if (!canAttack(target)) {
            log("공격 불가: 대상 " + target.getDisplayName());
            return;
        }
        log("화살을 " + target.getDisplayName() + " 에게 발사합니다!");
    }
}
