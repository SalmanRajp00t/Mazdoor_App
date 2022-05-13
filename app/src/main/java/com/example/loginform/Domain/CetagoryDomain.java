package com.example.loginform.Domain;

public class CetagoryDomain {
    private String title;
    private int pic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public CetagoryDomain(String title, int pic) {
        this.title = title;
        this.pic = pic;
    }
}
