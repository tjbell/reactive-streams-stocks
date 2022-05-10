package com.pluralsight.springwebflux5.stocktrading.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;
import java.util.*;

@SpringBootTest
class StockTradingApplicationTests {

    @Test
    void getDeclaredMethodsTest() {
        boolean getOneStockMethod = false;
        try {
            getOneStockMethod = Arrays.stream(StocksController.class.getDeclaredMethods()).anyMatch(method -> method.getName() == "getOneStock");
        } catch (Throwable e) { }

        assertTrue(getOneStockMethod, "Do you have a `getOneStock` method in the `StocksController` class?");
    }

    @Test
    void getDeclaredMethodTest() {
        Method getOneStockMethod = null;
        try {
            getOneStockMethod = StocksController.class.getDeclaredMethod("getOneStock", new Class[] { String.class });
        } catch (Throwable e) { }
        assertNotNull(getOneStockMethod, "Do you have a `getOneStock` method in the `StocksController` class?");
        assertEquals(getOneStockMethod.getReturnType().getName(), "reactor.core.publisher.Mono", "Does the `getOneStock` method have the correct return type?");
        // You could check the parameter count and types with getParameterCount and getParameterTypes
    }
}
