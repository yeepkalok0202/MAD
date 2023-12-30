package com.example.wia2007mad.socialmarket;

public class MarketData {

    private String name;
    private String course;
    private String marketDesc;
    private Integer imageUrl;
    //private String imageUrl;

    public MarketData(String name, String course, String marketDesc, Integer imageUrl) {
        this.name = name;
        this.course = course;
        this.marketDesc = marketDesc;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMarketDesc() {
        return marketDesc;
    }

    public void setMarketDesc(String marketDesc) {
        this.marketDesc = marketDesc;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
