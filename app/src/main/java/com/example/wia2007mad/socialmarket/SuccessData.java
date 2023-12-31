package com.example.wia2007mad.socialmarket;

public class SuccessData {

    public String successtext;
    public String imageUrl;

    public String url;

    public SuccessData() {
    }

    public SuccessData(String successtext, String imageUrl,String url) {
        this.successtext = successtext;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getSuccesstext() {
        return successtext;
    }

    public void setSuccesstext(String successtext) {
        this.successtext = successtext;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SuccessData{" +
                "successtext='" + successtext + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
