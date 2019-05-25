package com.roman.adoberoman.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.TreeMap;

@Service
public class GetRomanService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(GetRomanService.class);


    private final TreeMap<Integer,String> decToRomMap = new TreeMap<Integer,String>();

    @PostConstruct
    public void init() {
        LOGGER.debug("setting up roman map");
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

    public String calculateRoman(int query) {
        StringBuilder roman = new StringBuilder();
        while (query > 0) {
            // greatest key less than or equal to given key
            int num = decToRomMap.floorKey(query);

            int div = query / num;
            String val = decToRomMap.get(num);
            while (div > 0) {
                roman.append(val);
                div--;
            }
            query = query % num;
        }
        return roman.toString();
    }
}