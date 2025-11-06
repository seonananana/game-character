package com.example.game.units

import com.example.game.core.Point2D
import com.example.game.core.UnitBase
import com.example.game.traits.Attackable
import com.example.game.traits.Movable

/**
 * Archer(궁수): 걸어서 이동하며 화살로 지상/공중 모두 공격 가능.
 */
class Archer(id: Int, start: Point2D) :
    UnitBase(id = id, displayName = "궁수", position = start, isFlying = false),
    Movable, Attackable {

    override fun moveTo(dest: Point2D) {
        log("걸어서 $position → $dest 로 이동합니다. (기사는 말, 궁수는 도보로 더 느림)")
        position = dest
    }

    override fun attack(target: UnitBase) {
        log("화살을 쏘아 ${target.displayName}#${target.id} 를 공격합니다! (지상/공중 모두 가능)")
    }
}