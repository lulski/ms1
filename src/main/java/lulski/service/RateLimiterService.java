package lulski.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {

  HashMap<String, Integer> customerRegistry = new HashMap<String, Integer>();

  public boolean isAllowed(String customerId) {
    int requestCount;
    int timeCount = 60;

    System.out.println("heyy");

    if (!customerId.isEmpty() && !customerId.equals("")) {

      boolean keyExist = this.customerRegistry.containsKey(customerId);

      if (keyExist) {
        requestCount = this.customerRegistry.get(customerId);
        if (requestCount > 0) {
          requestCount++;
        }

        if (requestCount <= 1000) {
          this.customerRegistry.put(customerId, requestCount);
          System.out.println("hey it's allowd");
          return true;
        } else {
          System.out.println("noope not allowd");
          return false;
        }
      } else {
        this.customerRegistry.put(customerId, 1);
        return true;
      }

    }

    return false;
  }

}