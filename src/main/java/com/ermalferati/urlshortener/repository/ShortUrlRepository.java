package com.ermalferati.urlshortener.repository;

import com.ermalferati.urlshortener.model.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {
    ShortUrl findShortUrlByShortUrl (String shortUrl);
    ShortUrl findShortUrlByUrl (String url);
    ShortUrl save(ShortUrl shortUrl);
    List<ShortUrl> findAll();
}
