package com.clouduno.emisor.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE = "mensajes";
    public static final String TEST_QUEUE = "test";
    public static final String FANOUT_EXCHANGE = "mensajes.fanout";
}