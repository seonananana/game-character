package com.example.game.core;

public abstract class Unit {
    protected final String name;
    protected final int id;
    protected final boolean flying;
    protected Point2D position;

    protected Unit(String name, int id, boolean flying, Point2D startPos) {
        this.name = name;
        this.id = id;
        this.flying = flying;
        this.position = startPos;
    }

    public String getDisplayName() {
        return name + "#" + id;
    }

    public boolean isFlying() {
        return flying;
    }

    public Point2D getPosition() {
        return position;
    }

    protected void log(String msg) {
        System.out.println("[" + getDisplayName() + "] " + msg);
    }

    /** 기본 이동(지상 유닛용) */
    public void moveTo(Point2D dest) {
        log("걸어서 " + position + " -> " + dest + " 로 이동합니다.");
        this.position = dest;
    }

    /** 공격 가능 규칙은 하위 클래스에서 정의 */
    protected abstract boolean canAttack(Unit target);

    public final void attack(Unit target) {
        if (target == null) {
            log("공격 대상이 없습니다.");
            return;
        }
        if (target == this) {
            log("자기 자신은 공격할 수 없습니다.");
            return;
        }
        if (canAttack(target)) {
            log(target.getDisplayName() + " 을(를) 공격합니다. (대상 비행=" + target.isFlying() + ")");
        } else {
            log("공격 불가 대상입니다. (대상 비행=" + target.isFlying() + ")");
        }
    }
}
