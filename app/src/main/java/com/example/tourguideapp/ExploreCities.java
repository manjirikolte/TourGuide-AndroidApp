package com.example.tourguideapp;

public class ExploreCities {
    private String mInfoText;
    private String mImageResourceId;

    public ExploreCities(String mInfoText, String mImageResourceId) {
        this.mInfoText = mInfoText;
        this.mImageResourceId = mImageResourceId;
    }

    public String getInfoText() {
        return mInfoText;
    }

    public String getImageResourceId() {
        return mImageResourceId;
    }
}
