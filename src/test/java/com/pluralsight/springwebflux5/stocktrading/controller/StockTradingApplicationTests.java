package com.pluralsight.springwebflux5.stocktrading.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.lang.IllegalAccessException;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;
import java.lang.NoSuchMethodException;
import java.lang.ClassNotFoundException;
import java.lang.SecurityException;
import java.util.*;

@SpringBootTest
class StockTradingApplicationTests {

    @Test
    void constructorTest() throws IllegalAccessException, IOException {
        Field[] fields = Stock.class.getDeclaredFields();
        assertEquals(1, fields.length, "==> Have you created a `private String` field in the `Stock` class.");
        fields[0].setAccessible(true);
    }
    
    // @Test 
    // void getOneStockTest() throws IllegalAccessException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException {
    //     Class stocksControllerClass = Class.forName("com.pluralsight.springwebflux5.stocktrading.controller.StocksController");
    //     Method[] methods = stocksControllerClass.getDeclaredMethods();
    //     System.out.println(Arrays.stream(methods).filter(method -> method.getName() == "getOneStock").toString());
    //     // assertNotNull(methods, "==> Have you created a `method` called `getOneStock`?");
    // }

    @Test
    void getOneStockTest() {
        int actual = 0;
        Method getOneStockMethod = null;
    
        try {
            Class stocksControllerClass = Class.forName("com.pluralsight.springwebflux5.stocktrading.controller.StocksController");
            getOneStockMethod = stocksControllerClass.getMethod("getOneStock");
            // actual = (int) getOneStockMethod.invoke(statistics);
        } catch (Throwable e) { }

        assertNotNull(getOneStockMethod, "==> Have you defined the getOneStock method?");
        // assertEquals(185, actual, "==> The word count doesn't seem to be correct. Are you splitting on ` ` (space).");
    }

}
