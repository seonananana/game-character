
package com.example.game.core;

public interface Attackable {
    void attack(Unit target);
    boolean canAttack(Unit target);
}
