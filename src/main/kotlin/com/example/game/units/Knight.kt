package com.example.game.units

import com.example.game.core.Point2D
import com.example.game.core.UnitBase
import com.example.game.traits.Attackable
import com.example.game.traits.Movable

/**
 * Knight(기사): 말을 타고 이동하며 창으로 지상 유닛만 공격한다.
 * 비행 유닛(Shuttle, Griffin)은 규칙상 공격 불가.
 */
class Knight(id: Int, start: Point2D) :
    UnitBase(id = id, displayName = "기사", position = start, isFlying = false),
    Movable, Attackable {

    override fun moveTo(dest: Point2D) {
        log("말을 타고 $position → $dest 로 이동합니다.")
        position = dest
    }

    override fun attack(target: UnitBase) {
        if (target.isFlying) {
            log("공격 불가: 날아다니는 대상(${target.displayName}#${target.id})은 창으로 공격할 수 없습니다.")
            return
        }
        log("창으로 ${target.displayName}#${target.id} 를 찌릅니다!")
    }
}