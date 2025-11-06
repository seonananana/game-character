package com.example.game.units

import com.example.game.core.Point2D
import com.example.game.core.UnitBase
import com.example.game.traits.Attackable
import com.example.game.traits.Movable

/**
 * Griffin(그리핀): 하늘을 날아 이동하며, 번개로 지상 유닛만 공격한다.
 * 비행 유닛(Shuttle, Griffin)은 규칙상 공격 불가.
 */
class Griffin(id: Int, start: Point2D) :
    UnitBase(id = id, displayName = "그리핀", position = start, isFlying = true),
    Movable, Attackable {

    override fun moveTo(dest: Point2D) {
        log("하늘을 날아 $position → $dest 로 이동합니다.")
        position = dest
    }

    override fun attack(target: UnitBase) {
        if (target.isFlying) {
            log("공격 불가: 날아다니는 대상(${target.displayName}#${target.id})에게는 번개를 내릴 수 없습니다.")
            return
        }
        log("하늘에서 번개를 내려 ${target.displayName}#${target.id} 를 공격합니다!")
    }
}