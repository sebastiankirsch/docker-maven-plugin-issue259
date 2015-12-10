package de.is24.contrib.docker_maven_plugin_failure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Component
public class Worker implements SmartLifecycle {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private void initialize() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Thread.currentThread().getName());
        for (int i = 4; i-- > 0; ) {
            for (int j = 1000; j-- > 0; ) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = new Random().nextInt(3); ; ) {
                    for (int l = new Random().nextInt(10); l-- > 0; ) {
                        stringBuilder.append(String.format("#%s: %s", k, UUID.randomUUID()));
                    }
                    if (--k < 0) break;
                    else stringBuilder.append("\n");
                    logger.info(stringBuilder.toString());
                }
            }
            Thread.sleep(512);
        }
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        this.stop();
    }

    @Override
    public void start() {
        try {
            futureThing().get(8, TimeUnit.SECONDS);
            logger.info("Worker is initialized.");
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CompletableFuture<Void> futureThing() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        new Thread("Initializer-Thing") {
            @Override
            public void run() {
                try {
                    initialize();
                    LoggerFactory.getLogger("Worker-Init").info("INITIALIZED");
                    future.complete(null);
                } catch (InterruptedException e) {
                    // we're done
                }
            }
        }.start();
        new Thread("Distractor") {
            @Override
            public void run() {
                try {
                    initialize();
                } catch (InterruptedException e) {
                    // we're done
                }
            }
        }.start();
        return future;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
