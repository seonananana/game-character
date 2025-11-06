package com.example.game.core

/** 2차원 좌표를 표현하는 불변 데이터 클래스 */
data class Point2D(val x: Int, val y: Int) {
    override fun toString(): String = "($x, $y)"
}