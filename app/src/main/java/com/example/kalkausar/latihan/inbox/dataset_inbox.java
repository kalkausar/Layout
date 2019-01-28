package com.example.kalkausar.latihan.inbox;

public class dataset_inbox {

    private String title;
    private String view;

    public dataset_inbox() {
    }

    public dataset_inbox(String title, String view) {
        this.title = title;
        this.view = view;
    }

    //Getter
    public String getTitle() {
        return title;
    }

    public String getView() {
        return view;
    }

    //Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setView(String view) {
        this.view = view;
    }
}
