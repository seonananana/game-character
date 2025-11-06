package com.example.game.traits

import com.example.game.core.Point2D

/** 2D 좌표로 이동 가능한 행위 인터페이스 */
interface Movable {
    /** 목적지까지의 이동을 수행하고 한글 로그를 출력한다. */
    fun moveTo(dest: Point2D)
}