package com.example.kalkausar.latihan.Event;

public class cardMenu {
    private String tile;
    private String description;
    private int img;

    public cardMenu() {
    }

    public cardMenu(String tile, String description, int img) {
        this.tile = tile;
        this.description = description;
        this.img = img;
    }

    //Getter

    public String getTile() {
        return tile;
    }

    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }

    //Setter

    public void setTile(String tile) {
        this.tile = tile;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
