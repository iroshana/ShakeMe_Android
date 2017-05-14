package com.Model;

/**
 * Created by Ravindu on 5/14/2017.
 */

public class User{

    private String Name;
    private String OfferKey;
    private String OfferName;
    private String UserName;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOfferKey() {
        return OfferKey;
    }

    public void setOfferKey(String offerKey) {
        OfferKey = offerKey;
    }

    public String getOfferName() {
        return OfferName;
    }

    public void setOfferName(String offerName) {
        OfferName = offerName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
