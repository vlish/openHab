package com.lightservice.logger.config;

import com.lightservice.logger.cache.CacheStore;
import com.lightservice.logger.enums.LightItemState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

  @Bean
  public CacheStore<LightItemState> lightItemsCache() {
    return new CacheStore<>();
  }
}
