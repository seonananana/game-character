package com.example.game;

import com.example.game.core.Point2D;
import com.example.game.units.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point2D start = new Point2D(0, 0);
        Point2D dest  = new Point2D(100, 200);

        // 1) 유닛 생성: Knight 16, Archer 16, Shuttle 4, Griffin 5
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

        // 2) 탑승: 셔틀 4대에 각 8명씩 (기사/궁수 번갈아)
        int k = 0, a = 0;
        for (Shuttle s : shuttles) {
            for (int seat = 0; seat < s.getCapacity(); seat++) {
                if (seat % 2 == 0) {
                    s.board(knights.get(k++));
                } else {
                    s.board(archers.get(a++));
                }
            }
        }

        // 3) 이동: 셔틀 4대 + 그리핀 5기 목적지로 이동
        for (Shuttle s : shuttles) s.moveTo(dest);
        for (Griffin g : griffins) g.moveTo(dest);

        // 4) 하차: 목적지에서 전원 하차
        for (Shuttle s : shuttles) s.unloadAll();

        // 5) 공격 규칙 검증: Knight/Archer/Griffin 각각이 다양한 대상 공격 시도
        Knight atkK = knights.get(0);
        Archer atkA = archers.get(0);
        Griffin atkG = griffins.get(0);

        System.out.println("\n=== 공격 테스트: 기사 ===");
        atkK.attack(knights.get(1));   // 지상 OK
        atkK.attack(archers.get(1));   // 지상 OK
        atkK.attack(griffins.get(1));  // 비행 불가
        atkK.attack(shuttles.get(0));  // 비행 불가

        System.out.println("\n=== 공격 테스트: 궁수 ===");
        atkA.attack(archers.get(2));   // 지상 OK
        atkA.attack(knights.get(2));   // 지상 OK
        atkA.attack(griffins.get(2));  // 비행 OK
        atkA.attack(shuttles.get(1));  // 비행 OK

        System.out.println("\n=== 공격 테스트: 그리핀 ===");
        atkG.attack(griffins.get(3));  // 비행 불가
        atkG.attack(archers.get(3));   // 지상 OK
        atkG.attack(knights.get(3));   // 지상 OK
        atkG.attack(shuttles.get(2));  // 비행 불가
    }
}
