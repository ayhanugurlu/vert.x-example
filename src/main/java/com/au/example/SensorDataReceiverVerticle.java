package com.au.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensorDataReceiverVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(SensorDataReceiverVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) {
        vertx.eventBus().<JsonObject>consumer("temperature.updates", message ->
                logger.info("Received message: {}", message.body().encodePrettily()));
    }

    @Override
    public void stop(Promise<Void> stopPromise) throws Exception {
        super.stop(stopPromise);
    }
}
