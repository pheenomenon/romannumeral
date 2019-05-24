package com.roman.adoberoman.web;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.TreeMap;

@RestController
@RequestMapping(path = "/romannumeral")
public class DecimalToRomanController {

    private TreeMap<Integer,String> decToRomMap = new TreeMap<Integer,String>();

    @PostConstruct
    public void init() {
        decToRomMap.put(1000, "M");
        decToRomMap.put(900, "CM");
        decToRomMap.put(500, "D");
        decToRomMap.put(400, "CD");
        decToRomMap.put(100, "C");
        decToRomMap.put(90, "XC");
        decToRomMap.put(50, "L");
        decToRomMap.put(40, "XL");
        decToRomMap.put(10, "X");
        decToRomMap.put(9, "IX");
        decToRomMap.put(5, "V");
        decToRomMap.put(4, "IV");
        decToRomMap.put(1, "I");
    }

    @RequestMapping(method= RequestMethod.GET)
    public String convertDecimalToRoman(@RequestParam int query) {
        StringBuilder roman = new StringBuilder();

        /*validate query
         - only integer bad req
         - 1-3999 bad req
         -
        */
        if(query ==0 || query > 3999) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valid inputs are 1-3999");
        }

        //find roman
        while(query > 0) {
            // greatest key less than or equal to given key
            int num = decToRomMap.floorKey(query);

            int div = query / num;
            String val = decToRomMap.get(num);
            while(div > 0){
                roman.append(val);
                div--;
            }
            query = query % num;
        }

        return roman.toString();
    }

}
