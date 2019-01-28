package com.example.kalkausar.latihan.booking;

public class dataset_book {
    private String destination;
    private String date;
    private int img;

    public dataset_book() {
    }

    public dataset_book(String destination, String date, int img) {
        this.destination = destination;
        this.date = date;
        this.img = img;
    }

    //Getter
    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public int getImg() {
        return img;
    }

    //Setter

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
