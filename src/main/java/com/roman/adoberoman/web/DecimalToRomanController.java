package com.roman.adoberoman.web;


import com.roman.adoberoman.services.GetRomanService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/romannumeral")
@Api(value="roman", description = "Service to convert decimal to roman equivalents", tags = ("roman"))
public class DecimalToRomanController {

    @Autowired
    GetRomanService romanService;


    private static final Logger LOGGER =
            LoggerFactory.getLogger(DecimalToRomanController.class);

    private final Counter decimalToRomanCounter;

    public DecimalToRomanController(MeterRegistry registry) {
        this.decimalToRomanCounter = Counter.builder("api.convertDecimalToRoman").
                register(registry);
    }



    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Convert decimal to roman" ,notes = "Convert input decimal less than 3999 to roman", nickname = "convertDecimalToRoman")
    public String convertDecimalToRoman(@RequestParam int query) {
        decimalToRomanCounter.increment();
        LOGGER.debug("convertDecimalToRoman start called with query input : " + query);

        /*validate query
         - bad req for non-integer
         - bad req if not 1-3999
         -
        */
        if(query <=0 || query > 3999) {
            LOGGER.debug("invalid input throwing exception :" + query);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valid inputs are 1-3999");
        }

        //find roman
        String romanVal = romanService.calculateRoman(query);

        LOGGER.debug("convertDecimalToRoman ends output : " + romanVal);
        if(romanVal == "") {
            //something went wrong
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Valid inputs are 1-3999");
        }
        return romanVal;
    }


}
