package com.krash.applemart.SessionManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    private static SharedPreferences sharedPreferences;

    public SessionManagement() {
    }

    public static void init(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(SessionConstants.SESSION_NAME, Context.MODE_PRIVATE);
        }
    }

    public static boolean isLogged(){
        return sharedPreferences.getBoolean(SessionConstants.IS_LOGGED_IN, false);

    }

    public static void setLogin(boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SessionConstants.IS_LOGGED_IN, value);
        editor.apply();
    }

    public static void saveUserNum(String number){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.USER_NUMBER,number);
        editor.apply();
    }

    public static String  getNumber(){

        return sharedPreferences.getString(SessionConstants.USER_NUMBER,"");

    }

    public static void saveUserToken(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.USER_TOKEN,token);
        editor.apply();
    }

    public static String  getUserToken(){

        return sharedPreferences.getString(SessionConstants.USER_TOKEN,"");

    }

    public static void saveUserProfileName(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.USER_PROFILE_NAME,name);
        editor.apply();
    }

    public static String  getUserProfileName(){

        return sharedPreferences.getString(SessionConstants.USER_PROFILE_NAME,"");

    }

    public static void latitudeAddress(String latitude){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.LATITUDE,latitude);
        editor.apply();
    }

    public static String  getLatitudeAddress(){

        return sharedPreferences.getString(SessionConstants.LATITUDE,"");

    }

    public static void longitudeAddress(String longitude){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.LONGITUDE,longitude);
        editor.apply();
    }

    public static String  getLongitudeAddress(){

        return sharedPreferences.getString(SessionConstants.LONGITUDE,"");

    }

    public static void userProfileLatitudeAddress(String latitude){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.USER_PROFILE_LATITUDE,latitude);
        editor.apply();
    }

    public static String  getUserProfileLatitudeAddress(){

        return sharedPreferences.getString(SessionConstants.USER_PROFILE_LATITUDE,"");

    }

    public static void userProfileLongitudeAddress(String longitude){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.USER_PROFILE_LONGITUDE,longitude);
        editor.apply();
    }

    public static String  getUserProfileLongitudeAddress(){

        return sharedPreferences.getString(SessionConstants.USER_PROFILE_LONGITUDE,"");

    }



    public static void saveUserProfileImage(String image){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SessionConstants.USER_PROFILE_IMAGE,image);
        editor.apply();
    }

    public static String  getUserProfileImage(){

        return sharedPreferences.getString(SessionConstants.USER_PROFILE_IMAGE,"");

    }


}
