package com.ermalferati.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String url;
    private String shortUrl;

    public ShortUrl() {
    }

    public ShortUrl(String url, String shortUrl) {
        setUrl(url);
        this.shortUrl = shortUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        String tempUrl = "";
        if(!url.contains("http://") && !url.contains("https://"))
            tempUrl += "http://";
        tempUrl += url;
        this.url = tempUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}