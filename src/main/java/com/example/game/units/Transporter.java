package com.example.game.units;

import com.example.game.core.Unit;

import java.util.List;

public interface Transporter {
    boolean board(Unit u);        // 탑승
    List<Unit> unloadAll();       // 전체 하차
    int getCapacity();
    int getPassengerCount();
}
