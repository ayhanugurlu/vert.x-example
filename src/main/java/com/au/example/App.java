package com.au.example;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new SensorVerticle());
        vertx.deployVerticle(new SensorDataReceiverVerticle());

        vertx.eventBus().<JsonObject>consumer("temperature.updates", message ->
                logger.info("Received message: {}", message.body().encodePrettily())
        );
    }
}
