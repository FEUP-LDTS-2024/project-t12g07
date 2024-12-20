package com.towerdefense.model.game.elements;

import com.towerdefense.model.game.elements.towers.Tower;

import java.util.Arrays;
import java.util.List;

public class TowerShop extends Element{
    private int money;
    String[] TowerShopArt1;
    String[] TowerShopArt2;
    String[] TowerShopArt3;
    String[] SideBarArt;
    private final List<String> entries;
    private int currentEntry = 0;


    public TowerShop(int x, int y) {
        super(x, y);
        this.entries = Arrays.asList("Wood Tower: 10€", "Stone Tower: 20€", "Metal Tower: 30€");
        this.money = 30;
        this.TowerShopArt1 = new String[] {
                "┌┐┌┐┌┐",
                "├┘└┘└┤",
                "│x  x│",
                "│ ┌┐ │",
                "└─└┘─┘"

        };

        this.TowerShopArt2 = new String[] {
                "┌┐┌┐┌┐" ,
                "├┘└┘└┤" ,
                "│▲  ▲│" ,
                "│x┌┐x│" ,
                "└┘└┘└┘"
        };

        this.TowerShopArt3 = new String[] {
                "▲┐┌┐┌▲",
                "├┘└┘└┤",
                "│▲──▲│",
                "││┌┐││",
                "└┘└┘└┘"
        };

        this.SideBarArt = new String[] {
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│",
                "│"
        };

    }

    public int getMoney() {
        return money;
    }

    public boolean purchaseTower(Tower tower) {
        if (money >= tower.getCost()) {
            money -= tower.getCost();
            return true;
        }
        return false;
    }

    public void addReward(int reward){
        this.money += reward;
    }

    public String[] getTowerShopArt1() {
        return TowerShopArt1;
    }

    public String[] getTowerShopArt2() {
        return TowerShopArt2;
    }

    public String[] getTowerShopArt3() {
        return TowerShopArt3;
    }

    public String[] getSideBarArt() {
        return SideBarArt;
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelected1() {
        return isSelected(0);
    }

    public boolean isSelected2() {
        return isSelected(1);
    }

    public boolean isSelected3() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

}
