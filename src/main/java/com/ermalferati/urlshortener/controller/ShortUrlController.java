package com.ermalferati.urlshortener.controller;

import com.ermalferati.urlshortener.model.ShortUrl;
import com.ermalferati.urlshortener.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @GetMapping("/")
    public String shortenUrl(@RequestParam(value = "url", required = false) String url, Map<String, Object> model, HttpServletRequest request){
        if(url != null) {
            ShortUrl shortUrl = shortUrlService.findShortUrlByUrl(url);
            model.put("url", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + shortUrl.getShortUrl());
        }
        return "index";
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable(value = "url") String url, Map<String, Object> model) {
        ShortUrl shortUrl = shortUrlService.findShortUrlByShortUrl(url);

        if(shortUrl == null){
            model.put("code", "Error 404");
            model.put("message", "Shortened url not found");
            return "error";
        }

        return "redirect:" + shortUrl.getUrl();
    }

    @GetMapping("/url")
    @ResponseBody
    public List<ShortUrl> shortUrls(){
        return shortUrlService.findAllShortUrl();
    }
}
