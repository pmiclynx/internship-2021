package com.internship.tvseries.data.repository.config;

import com.internship.tvseries.data.model.Configuration;

import java.util.function.Consumer;

public class LynxConfigRepository implements ConfigRepository {

    private static LynxConfigRepository instance = null;

    private LynxConfigRepository(){}

    public static LynxConfigRepository getInstance() {
        synchronized (LynxConfigRepository.class) {
            if (instance == null)
                instance = new LynxConfigRepository();
        }
        return instance;
    }

    @Override
    public void getConfig(Consumer<Configuration> consumer) {
        //TODO implement method
        consumer.accept(null);
    }
}
