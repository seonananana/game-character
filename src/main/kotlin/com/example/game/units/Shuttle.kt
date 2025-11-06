package com.example.game.units

import com.example.game.core.Point2D
import com.example.game.core.UnitBase
import com.example.game.traits.Movable
import com.example.game.traits.Transporter

/**
 * Shuttle(셔틀): Knight/Archer만 탑승 가능한 비행 수송 유닛. 정원은 8.
 */
class Shuttle(id: Int, start: Point2D) :
    UnitBase(id = id, displayName = "셔틀", position = start, isFlying = true),
    Movable, Transporter {

    override val capacity: Int = 8
    private val passengers = mutableListOf<UnitBase>()

    override fun moveTo(dest: Point2D) {
        log("하늘을 날아 $position → $dest 로 이동합니다. (탑승자 ${passengers.size}명 동반)")
        position = dest
    }

    override fun board(unit: UnitBase): Boolean {
        val allowed = unit is Knight || unit is Archer
        if (!allowed) {
            log("탑승 실패: ${unit.displayName}#${unit.id} 은(는) 탑승할 수 없습니다.")
            return false
        }
        if (passengers.size >= capacity) {
            log("탑승 실패: 정원 초과(${capacity}).")
            return false
        }
        passengers += unit
        log("${unit.displayName}#${unit.id} 탑승 완료. (현재 ${passengers.size}/${capacity})")
        return true
    }

    override fun disembarkAll(): List<UnitBase> {
        if (passengers.isEmpty()) {
            log("하차할 승객이 없습니다.")
            return emptyList()
        }
        val out = passengers.toList()
        passengers.clear()
        log("승객 ${out.size}명 전원 하차.")
        return out
    }
}