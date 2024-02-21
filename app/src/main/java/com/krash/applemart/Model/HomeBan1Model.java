package com.krash.applemart.Model;

public class HomeBan1Model {

    //homeban1
    String title,desc,btntext;
    int banImg;


    public HomeBan1Model(String title, String desc,String btntext, int banImg) {
        this.title = title;
        this.desc = desc;
        this.banImg = banImg;
        this.btntext = btntext;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getBanImg() {
        return banImg;
    }

    public void setBanImg(int banImg) {
        this.banImg = banImg;
    }

    public String getBtntext() {
        return btntext;
    }

    public void setBtntext(String btntext) {
        this.btntext = btntext;
    }


    //ItemWeGotCovered
    String coveredtext;
    int coveredImg;

    public HomeBan1Model(String coveredtext, int coveredImg) {
        this.coveredtext = coveredtext;
        this.coveredImg = coveredImg;
    }

    public String getCoveredtext() {
        return coveredtext;
    }

    public void setCoveredtext(String coveredtext) {
        this.coveredtext = coveredtext;
    }

    public int getCoveredImg() {
        return coveredImg;
    }

    public void setCoveredImg(int coveredImg) {
        this.coveredImg = coveredImg;
    }
}
