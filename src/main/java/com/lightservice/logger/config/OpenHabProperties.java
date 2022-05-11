package com.lightservice.logger.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "open-hab")
public class OpenHabProperties {

  private String itemsUrl;

  private String stateChangeEventUrl;

}
