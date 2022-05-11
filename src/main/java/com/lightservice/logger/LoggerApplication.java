package com.lightservice.logger;

import com.lightservice.logger.client.OpenHabItemsHandler;
import com.lightservice.logger.model.Item;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LoggerApplication implements ApplicationRunner {

  @Autowired
  private OpenHabItemsHandler openHabItemsHandler;

  public static void main(String[] args) {
    SpringApplication.run(LoggerApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Item> items = openHabItemsHandler.storeAllItems();
    log.info("Item states log: ", items);
  }

}
