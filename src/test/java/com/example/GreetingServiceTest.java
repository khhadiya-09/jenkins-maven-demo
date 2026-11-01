package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    @Test
    void testGreeting() {
        GreetingService service = new GreetingService();

        String result = service.getGreeting("Hadiya");

        assertEquals(
            "Hello, Hadiya! Welcome to Jenkins CI/CD.",
            result
        );
    }
}
