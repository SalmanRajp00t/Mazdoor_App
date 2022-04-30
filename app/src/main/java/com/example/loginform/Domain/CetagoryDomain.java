package com.example.loginform.Domain;

public class CetagoryDomain {
    private String title;
    private String pic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public CetagoryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }
}
