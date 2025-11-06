package com.example.game.traits

import com.example.game.core.UnitBase

/** 다른 유닛을 수송하는 행위 인터페이스 */
interface Transporter {
    /** 탑승 정원 */
    val capacity: Int

    /**
     * 유닛을 탑승시킨다.
     * @return 성공 여부 (실패 시 한글 사유 로그 출력 권장)
     */
    fun board(unit: UnitBase): Boolean

    /**
     * 모든 탑승자를 하차시킨다.
     * @return 하차한 유닛 목록
     */
    fun disembarkAll(): List<UnitBase>
}