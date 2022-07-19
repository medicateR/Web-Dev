package com.example.assignment.Service;



import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface UrlService  {

    void storeurl(String url);

    int get(String url);

    int count(String url);

    Map<String,Integer> list(int pageNO, int size);

}
