package com.lightservice.logger.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheStore<T> {

  private Cache<String, T> cache;

  //Constructor to build Cache Store
  public CacheStore() {
    cache = CacheBuilder.newBuilder()
        .concurrencyLevel(Runtime.getRuntime().availableProcessors())
        .build();
  }

  //Method to fetch previously stored record using record key
  public T get(String key) {
    return cache.getIfPresent(key);
  }

  //Method to put a new record in Cache Store with record key
  public void add(String key, T value) {
    if (key != null && value != null) {
      cache.put(key, value);
      log.info("Record stored in "
          + value.getClass().getSimpleName()
          + " Cache with Key = " + key);
    }
  }

}
