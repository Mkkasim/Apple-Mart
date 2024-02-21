package com.krash.applemart.Model;

public class ItemInHomeModel {

    //iteminmain
    String DescText;
    int  Image;

    public ItemInHomeModel(int Image, String DescText) {
        this.DescText = DescText;
        this.Image = Image;
    }
    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDescText() {
        return DescText;
    }

    public void setDescText(String descText) {
        DescText = descText;
    }


    //ItemMustTryModel
    String mustTryText;
    int mustImg;

    public ItemInHomeModel(String mustTryText, int mustImg) {
        this.mustTryText = mustTryText;
        this.mustImg = mustImg;
    }

    public String getMustTryText() {
        return mustTryText;
    }

    public void setMustTryText(String mustTryText) {
        this.mustTryText = mustTryText;
    }

    public int getMustImg() {
        return mustImg;
    }

    public void setMustImg(int mustImg) {
        this.mustImg = mustImg;
    }



}
