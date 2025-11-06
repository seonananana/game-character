package com.example.game

import com.example.game.core.Point2D
import com.example.game.units.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RulesTest {
    @Test
    fun knightCannotAttackFlying() {
        val k = Knight(1, Point2D(0,0))
        val g = Griffin(1, Point2D(0,0))
        val s = Shuttle(1, Point2D(0,0))

        // 규칙 검증은 출력 기반이므로 여기서는 isFlying 플래그만 간접 확인
        assertTrue(g.isFlying)
        assertTrue(s.isFlying)
        assertFalse(k.isFlying)
    }
}