
package com.example.game.units;

import com.example.game.core.*;

public class Knight extends Unit implements Attackable {

    public Knight(int id, Point2D startPos) {
        super("기사", id, false, startPos);
    }

    @Override
    public void moveTo(Point2D dest) {
        log("말을 타고 " + position + " -> " + dest + " 로 이동합니다.");
        this.position = dest;
    }

    @Override
    public boolean canAttack(Unit target) {
        // Knight cannot attack flying targets
        return !target.isFlying();
    }

    @Override
    public void attack(Unit target) {
        if (!canAttack(target)) {
            log("공격 불가: 날아다니는 유닛은 창으로 찌를 수 없습니다. (" + target.getDisplayName() + ")");
            return;
        }
        log("창으로 " + target.getDisplayName() + " 를 찌릅니다!");
    }
}
