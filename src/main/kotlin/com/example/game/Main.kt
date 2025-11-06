package com.example.game

import com.example.game.core.Point2D
import com.example.game.units.*

fun main() {
    println("=== 게임 시작: 캐릭터 생성 ===")

    val start = Point2D(0, 0)
    val knights = (1..16).map { Knight(it, start) }
    val archers = (1..16).map { Archer(it, start) }
    val shuttles = (1..4).map { Shuttle(it, start) }
    val griffins = (1..5).map { Griffin(it, start) }

    println("\n=== 셔틀 탑승: Knight 16, Archer 16 → Shuttle 4대(정원 8×4=32) ===")
    val toBoard = knights + archers
    var idx = 0
    for (u in toBoard) {
        val shuttle = shuttles[idx % shuttles.size]
        if (!shuttle.board(u)) {
            shuttles.firstOrNull { it.board(u) }
        }
        idx++
    }

    println("\n=== Griffin 5기 + Shuttle 4대가 함께 이동 ===")
    val dest = Point2D(100, 50)
    shuttles.forEach { it.moveTo(dest) }
    griffins.forEach { it.moveTo(dest) }

    println("\n=== 도착지에서 셔틀 전원 하차 ===")
    val disembarked = shuttles.flatMap { it.disembarkAll() }
    disembarked.forEach {
        println("[${it.displayName}#${it.id}] 도착지 $dest 에 하차했습니다.")
    }

    println("\n=== 전투 시연 ===")
    val k1 = knights.first()
    val a1 = archers.first()
    val g1 = griffins.first()
    val s1 = shuttles.first()

    println("\n- Knight의 공격 시연(타입별 1기):")
    k1.attack(knights[1])
    k1.attack(archers[1])
    k1.attack(griffins[1]) // 공중 공격 불가
    k1.attack(s1)          // 공중 공격 불가

    println("\n- Archer의 공격 시연(타입별 1기):")
    a1.attack(archers[1])
    a1.attack(knights[2])
    a1.attack(griffins[2]) // 가능
    a1.attack(s1)          // 가능

    println("\n- Griffin의 공격 시연(타입별 1기):")
    g1.attack(griffins[3]) // 공중 공격 불가
    g1.attack(archers[2])  // 가능(지상)
    g1.attack(knights[3])  // 가능(지상)
    g1.attack(s1)          // 공중 공격 불가

    println("\n=== 시연 종료 ===")
}