package com.ermalferati.urlshortener.service;

import com.ermalferati.urlshortener.model.ShortUrl;
import com.ermalferati.urlshortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ShortUrlService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private Random random;

    private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public ShortUrl findShortUrlByShortUrl(String shortUrl){
        return shortUrlRepository.findShortUrlByShortUrl(shortUrl);
    }

    public ShortUrl findShortUrlByUrl(String url){
        ShortUrl shortUrl = shortUrlRepository.findShortUrlByUrl(url);
        if(shortUrl == null){
            String shortenedUrl = "";
            while(shortUrl == null || shortUrlRepository.findShortUrlByShortUrl(shortenedUrl) != null) {
                for (int i = 0; i < 5; i++) {
                    shortenedUrl += alphabet.charAt(random.nextInt(alphabet.length()));
                }
                shortUrl = new ShortUrl(url, shortenedUrl);
            }
            shortUrlRepository.save(shortUrl);
        }
        return shortUrl;
    }

    public List<ShortUrl> findAllShortUrl(){
        return shortUrlRepository.findAll();
    }

    @Bean
    public Random randomGenerator(){
        if(random != null)
            return random;
        return random = new Random();
    }
}