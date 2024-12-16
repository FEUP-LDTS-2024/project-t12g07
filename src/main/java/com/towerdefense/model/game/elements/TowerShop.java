package com.towerdefense.model.game.elements;

import com.towerdefense.model.game.elements.towers.Tower;

public class TowerShop extends Element{
    private int money;
    String[] TowerShopArt1;
    String[] TowerShopArt2;
    String[] TowerShopArt3;
    String[] SideBarArt;


    public TowerShop(int x, int y) {
        super(x, y);
        this.TowerShopArt1 = new String[] {
                "┌┐┌┐┌┐",
                "├┘└┘└┤",
                "│x  x│",
                "│x  x│",
                "│ ┌┐ │",
                "└─└┘─┘"

        };

        this.TowerShopArt2 = new String[] {
                "┌┐┌┐┌┐" ,
                "├┘└┘└┤" ,
                "│▲  ▲│" ,
                "││  ││" ,
                "│x┌┐x│" ,
                "└┘└┘└┘"
        };

        this.TowerShopArt3 = new String[] {
                "▲┐┌┐┌▲",
                "├┘└┘└┤",
                "│x  x│",
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
}
