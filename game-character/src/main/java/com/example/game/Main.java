
package com.example.game;

import com.example.game.core.Point2D;
import com.example.game.core.Unit;
import com.example.game.core.Attackable;
import com.example.game.units.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 시작 위치 (0,0), 목적지 (100,200)
        Point2D start = new Point2D(0, 0);
        Point2D dest = new Point2D(100, 200);

        // 유닛 생성
        List<Knight> knights = new ArrayList<>();
        List<Archer> archers = new ArrayList<>();
        List<Griffin> griffins = new ArrayList<>();
        List<Shuttle> shuttles = new ArrayList<>();

        for (int i = 1; i <= 16; i++) {
            knights.add(new Knight(i, start));
            archers.add(new Archer(i, start));
        }
        for (int i = 1; i <= 5; i++) {
            griffins.add(new Griffin(i, start));
        }
        for (int i = 1; i <= 4; i++) {
            shuttles.add(new Shuttle(i, start));
        }

        // 탑승: Knight/Archer 32명 -> Shuttle 4대 (각 8명)
        int kIdx = 0, aIdx = 0;
        for (Shuttle s : shuttles) {
            for (int seat = 0; seat < 8; seat++) {
                // 번갈아 태우기: Knight 1, Archer 1 ...
                if (kIdx < knights.size()) {
                    s.board(knights.get(kIdx++));
                } else if (aIdx < archers.size()) {
                    s.board(archers.get(aIdx++));
                }
                if (aIdx < archers.size() && seat < 7) {
                    s.board(archers.get(aIdx++));
                    seat++;
                }
            }
        }

        // 이동: Shuttle 4대 + Griffin 5기
        System.out.println("=== 이동 시작 ===");
        for (Shuttle s : shuttles) s.moveTo(dest);
        for (Griffin g : griffins) g.moveTo(dest);
        System.out.println("=== 이동 종료 ===\n");

        // 하차: 모든 셔틀 승객
        System.out.println("=== 하차 시작 ===");
        for (Shuttle s : shuttles) s.disembarkAll();
        System.out.println("=== 하차 종료 ===\n");

        // 공격 시나리오
        // Knight 1기 선택하여 Knight/Archer/Griffin/Shuttle 각각 공격
        Knight atkKnight = knights.get(0);
        System.out.println("=== Knight 공격 테스트 ===");
        atkKnight.attack(knights.get(1));
        atkKnight.attack(archers.get(1));
        atkKnight.attack(griffins.get(0));
        atkKnight.attack(shuttles.get(0));
        System.out.println();

        // Archer 1기 선택
        Archer atkArcher = archers.get(0);
        System.out.println("=== Archer 공격 테스트 ===");
        atkArcher.attack(archers.get(1));
        atkArcher.attack(knights.get(2));
        atkArcher.attack(griffins.get(1));
        atkArcher.attack(shuttles.get(1));
        System.out.println();

        // Griffin 1기 선택
        Griffin atkGriffin = griffins.get(2);
        System.out.println("=== Griffin 공격 테스트 ===");
        atkGriffin.attack(griffins.get(3));
        atkGriffin.attack(archers.get(2));
        atkGriffin.attack(knights.get(3));
        atkGriffin.attack(shuttles.get(2));
        System.out.println();

        System.out.println("=== 시뮬레이션 종료 ===");
    }
}
