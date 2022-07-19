package com.example.assignment.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignment.Service.UrlService;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/storeurl/{url}")
    public void store(@PathVariable(value = "url") String url){
        urlService.storeurl(url);
    }
    @GetMapping("/get/{url}")
    public int get(@PathVariable(value = "url") String url){
        return urlService.get(url);
    }
    @GetMapping("/count/{url}")
    public int count(@PathVariable(value = "url")String url){
        return urlService.count(url);
    }

    @GetMapping("/list")
    public Map<String,Integer> list( @RequestParam(value = "pageNO", defaultValue ="1", required = false) int pageNO,
                                           @RequestParam(value = "size", defaultValue ="5", required = false) int size){
        return urlService.list( pageNO, size);
    }

}
