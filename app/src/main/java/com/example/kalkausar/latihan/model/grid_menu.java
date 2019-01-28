package com.example.kalkausar.latihan.model;

public class grid_menu {
    private String menuName;
    private int menuImage;

    public grid_menu(String menuName,int menuImage) {
        this.menuName = menuName;
        this.menuImage = menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuImage() {
        return menuImage;
    }
}
