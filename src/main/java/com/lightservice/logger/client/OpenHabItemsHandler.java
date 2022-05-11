package com.lightservice.logger.client;

import com.lightservice.logger.cache.CacheStore;
import com.lightservice.logger.config.OpenHabProperties;
import com.lightservice.logger.enums.LightItemState;
import com.lightservice.logger.model.Item;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(OpenHabProperties.class)
public class OpenHabItemsHandler {

  private final OpenHabProperties openHabProperties;
  private final WebClient.Builder webClient;
  private final CacheStore<LightItemState> itemNameStateCache;

  //Probably this can be moved to static block to execute once during classloading
  // After first execuion cache will be used instead of calling every time Rest API.
  public List<Item> storeAllItems() {
    List<Item> items = Objects.requireNonNull(webClient.build()
        .post()
        .uri(openHabProperties.getItemsUrl())
        .header(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON))
        .retrieve()
        .toEntityList(Item.class)
        .block())
        .getBody();
    items.forEach(
        item -> itemNameStateCache.add(item.getName(), LightItemState.valueOf(item.getState())));

    return items;
  }

  //TODO: Subscriber for state change event and update cache logic here


}
