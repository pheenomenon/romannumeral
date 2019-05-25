package com.roman.adoberoman.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetRomanServiceTest {

    @InjectMocks
    GetRomanService svc;

    @Before
    public void setup() {
        svc.init();
    }

    @Test
    public void testCalculateRoman() {
        assertEquals("DCLXXVI",svc.calculateRoman(676));
    }

}