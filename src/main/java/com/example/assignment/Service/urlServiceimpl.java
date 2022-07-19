package com.example.assignment.Service;


import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class urlServiceimpl implements UrlService {

    HashMap<String, Integer> map1 = new LinkedHashMap<>();
    HashMap<String, Integer> map2 = new LinkedHashMap<>();

     int keygenerator(){
       int value = 0;
       Random random = new Random();
       for (int i = 0; i < 5; i++) {
           value = value * 10 + random.nextInt(10);
       }
       return value;
     }
    @Override
   synchronized public void storeurl(String url) {
      int value= keygenerator();
        map1.put(url, value);

        if (map2.containsKey(url)) {
      System.out.println("Url already exists in our system");
        } else {
            map2.put(url, 0);
        }
    }

    @Override
   synchronized public int get(String url) {
        if (map2.containsKey(url)) {
            int count = map2.get(url);
            map2.put(url, count + 1);
        }
        else {
            System.out.println("The provided url does not exists, you can add it using storeurl");
        }
        int resp = map1.get(url);
        return resp;
    }

    @Override
   synchronized public int count(String url) {
        int resp = 0;
        if (map2.containsKey(url)) {
            resp = map2.get(url);
            return resp;
        }
        else {
            System.out.println("The provided url does not exists, you can add it using storeurl");
        }
        return resp;
    }

    @Override
   synchronized public Map<String, Integer> list(int pageNO, int size) {

        if (pageNO > 0 || size > 0) {

            Map<String, Integer> res = new LinkedHashMap<>();
            int start = (pageNO * size) - size;
            int last = pageNO * size;
            last=Math.min(map1.size(),last);
            List<String> keyList = new ArrayList<String>(map1.keySet());
            for (int i = start; i < last; i++) {
                String key = keyList.get(i);
                Integer value = map1.get(key);
                res.put(key, value);
            }
                return res;

        }
        return map2;


    }
}


