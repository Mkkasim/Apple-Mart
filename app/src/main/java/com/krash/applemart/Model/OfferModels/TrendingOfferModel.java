package com.krash.applemart.Model.OfferModels;

public class TrendingOfferModel {
    int imgtop,imgback;
    String text_offer;

    public TrendingOfferModel(int imgtop, int imgback, String text_offer) {
        this.imgtop = imgtop;
        this.imgback = imgback;
        this.text_offer = text_offer;
    }

    public int getImgtop() {
        return imgtop;
    }

    public void setImgtop(int imgtop) {
        this.imgtop = imgtop;
    }

    public int getImgback() {
        return imgback;
    }

    public void setImgback(int imgback) {
        this.imgback = imgback;
    }

    public String getText_offer() {
        return text_offer;
    }

    public void setText_offer(String text_offer) {
        this.text_offer = text_offer;
    }



    //trending brand model
    int img_brand;

    public TrendingOfferModel(int img_brand) {
        this.img_brand = img_brand;
    }

    public int getImg_brand() {
        return img_brand;
    }

    public void setImg_brand(int img_brand) {
        this.img_brand = img_brand;
    }
}
