# openHab

High Level Design

1)	Spring Boot Application with Rest Template/Web Client/Feign Client used to call   http://demo.openhab.org/rest/items?tags=light 

2)	Create cache with key as item name and value as state of this item (Light_FF_Daughter_Ceiling = OFF)

3)	Subscribe to Event Bus provided by OpenHAB -> openhab/items/{itemName}/state to update state of the items inside our cache and log all items with new states.

4)	On Spring Boot Application add Java Appender to ship logs every 10 second to logz io for further work with them on logz io platform


![image](https://user-images.githubusercontent.com/10356708/167868781-607ace5a-9712-4625-bc6d-2df71decefa4.png)

