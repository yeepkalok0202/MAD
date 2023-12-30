package com.example.wia2007mad.socialmarket;

public class SuccessData {

    private String successtext;
    private Integer imageUrl;

    public SuccessData(String successtext, Integer imageUrl) {
        this.successtext = successtext;
        this.imageUrl = imageUrl;
    }

    public String getSuccesstext() {
        return successtext;
    }

    public void setSuccesstext(String successtext) {
        this.successtext = successtext;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "SuccessData{" +
                "successtext='" + successtext + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
