package com.example.game.core

/**
 * 모든 유닛의 공통 속성과 로그 출력을 담당하는 기반 클래스.
 * @property id 유닛 고유 번호
 * @property displayName 출력용 한글 이름
 * @property position 현재 좌표
 * @property isFlying 공중 유닛 여부(공격 규칙에 영향)
 */
abstract class UnitBase(
    val id: Int,
    val displayName: String,
    var position: Point2D,
    val isFlying: Boolean
) {
    /** 공통 로그 포맷을 한글로 출력한다. */
    protected fun log(msg: String) = println("[$displayName#$id] $msg")
}