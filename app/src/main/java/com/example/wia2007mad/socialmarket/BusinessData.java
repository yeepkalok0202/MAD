package com.example.wia2007mad.socialmarket;

public class BusinessData {

    private String name;
    private String course;
    private String businessDesc;
    private Integer imageUrl;
    //private String imageUrl;

    public BusinessData(String name, String course, String businessDesc, Integer imageUrl) {
        this.name = name;
        this.course = course;
        this.businessDesc = businessDesc;
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

    public String getbusinessDesc() {
        return businessDesc;
    }

    public void setbusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}