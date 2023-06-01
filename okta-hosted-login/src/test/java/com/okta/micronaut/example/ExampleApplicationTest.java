package com.okta.micronaut.example;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class ExampleApplicationTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testHello(@Client("/") HttpClient client) {
        String message = client
                .toBlocking()
                .retrieve("/");
        assertTrue(message.contains("Okta Hosted Login + Micronaut Example"));
    }
}
