package com.krash.applemart.Model;

public class FruitsVegetablesModel {

    String offerPercent,productShortName,productFullName,productShortdes,productLongDes,productActualAmount,productFakeAmount,
    productsShelfLife,productUnit,manufacturerDetails,marketedBy,fssaiLicense,productsDisclaimer,country,customerCareDetails,
    productsClass,seller,ExpiryDate;
    int Image1,Image2,Image3,Image4;

    public FruitsVegetablesModel(String offerPercent, String productShortName, String productFullName, String productShortdes, String productLongDes, String productActualAmount, String productFakeAmount, String productsShelfLife, String productUnit, String manufacturerDetails, String marketedBy, String fssaiLicense, String productsDisclaimer, String country, String customerCareDetails, String productsClass, String seller, String expiryDate, int image1, int image2, int image3, int image4) {
        this.offerPercent = offerPercent;
        this.productShortName = productShortName;
        this.productFullName = productFullName;
        this.productShortdes = productShortdes;
        this.productLongDes = productLongDes;
        this.productActualAmount = productActualAmount;
        this.productFakeAmount = productFakeAmount;
        this.productsShelfLife = productsShelfLife;
        this.productUnit = productUnit;
        this.manufacturerDetails = manufacturerDetails;
        this.marketedBy = marketedBy;
        this.fssaiLicense = fssaiLicense;
        this.productsDisclaimer = productsDisclaimer;
        this.country = country;
        this.customerCareDetails = customerCareDetails;
        this.productsClass = productsClass;
        this.seller = seller;
        this.ExpiryDate = expiryDate;
        this.Image1 = image1;
        this.Image2 = image2;
        this.Image3 = image3;
        this.Image4 = image4;
    }

    public String getOfferPercent() {
        return offerPercent;
    }

    public void setOfferPercent(String offerPercent) {
        this.offerPercent = offerPercent;
    }

    public String getProductShortName() {
        return productShortName;
    }

    public void setProductShortName(String productShortName) {
        this.productShortName = productShortName;
    }

    public String getProductFullName() {
        return productFullName;
    }

    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }

    public String getProductShortdes() {
        return productShortdes;
    }

    public void setProductShortdes(String productShortdes) {
        this.productShortdes = productShortdes;
    }

    public String getProductLongDes() {
        return productLongDes;
    }

    public void setProductLongDes(String productLongDes) {
        this.productLongDes = productLongDes;
    }

    public String getProductActualAmount() {
        return productActualAmount;
    }

    public void setProductActualAmount(String productActualAmount) {
        this.productActualAmount = productActualAmount;
    }

    public String getProductFakeAmount() {
        return productFakeAmount;
    }

    public void setProductFakeAmount(String productFakeAmount) {
        this.productFakeAmount = productFakeAmount;
    }

    public String getProductsShelfLife() {
        return productsShelfLife;
    }

    public void setProductsShelfLife(String productsShelfLife) {
        this.productsShelfLife = productsShelfLife;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getManufacturerDetails() {
        return manufacturerDetails;
    }

    public void setManufacturerDetails(String manufacturerDetails) {
        this.manufacturerDetails = manufacturerDetails;
    }

    public String getMarketedBy() {
        return marketedBy;
    }

    public void setMarketedBy(String marketedBy) {
        this.marketedBy = marketedBy;
    }

    public String getFssaiLicense() {
        return fssaiLicense;
    }

    public void setFssaiLicense(String fssaiLicense) {
        this.fssaiLicense = fssaiLicense;
    }

    public String getProductsDisclaimer() {
        return productsDisclaimer;
    }

    public void setProductsDisclaimer(String productsDisclaimer) {
        this.productsDisclaimer = productsDisclaimer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCustomerCareDetails() {
        return customerCareDetails;
    }

    public void setCustomerCareDetails(String customerCareDetails) {
        this.customerCareDetails = customerCareDetails;
    }

    public String getProductsClass() {
        return productsClass;
    }

    public void setProductsClass(String productsClass) {
        this.productsClass = productsClass;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public int getImage1() {
        return Image1;
    }

    public void setImage1(int image1) {
        Image1 = image1;
    }

    public int getImage2() {
        return Image2;
    }

    public void setImage2(int image2) {
        Image2 = image2;
    }

    public int getImage3() {
        return Image3;
    }

    public void setImage3(int image3) {
        Image3 = image3;
    }

    public int getImage4() {
        return Image4;
    }

    public void setImage4(int image4) {
        Image4 = image4;
    }


    //Summers
    String drinkText;
    int drinkImg;

    public FruitsVegetablesModel(String drinkText, int drinkImg) {
        this.drinkText = drinkText;
        this.drinkImg = drinkImg;
    }

    public String getDrinkText() {
        return drinkText;
    }

    public void setDrinkText(String drinkText) {
        this.drinkText = drinkText;
    }

    public int getDrinkImg() {
        return drinkImg;
    }

    public void setDrinkImg(int drinkImg) {
        this.drinkImg = drinkImg;
    }
}
