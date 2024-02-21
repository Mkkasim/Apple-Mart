package com.krash.applemart.Model;

public class ProductImagesOfferModel {

    String offerPercent;
    int image1,image2,image3,image4;

    public ProductImagesOfferModel(String offerPercent, int image1, int image2, int image3, int image4) {
        this.offerPercent = offerPercent;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public String getOfferPercent() {
        return offerPercent;
    }

    public void setOfferPercent(String offerPercent) {
        this.offerPercent = offerPercent;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public int getImage4() {
        return image4;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }


    //trending search
    String textSearch;
    int imgSearch;

    public ProductImagesOfferModel(String textSearch, int imgSearch) {
        this.textSearch = textSearch;
        this.imgSearch = imgSearch;
    }

    public String getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }

    public int getImgSearch() {
        return imgSearch;
    }

    public void setImgSearch(int imgSearch) {
        this.imgSearch = imgSearch;
    }
}
