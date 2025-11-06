package com.example.game.traits

import com.example.game.core.UnitBase

/** 공격 가능한 행위 인터페이스 */
interface Attackable {
    /** 대상 유닛을 공격한다(규칙은 구현체에서 적용). */
    fun attack(target: UnitBase)
}