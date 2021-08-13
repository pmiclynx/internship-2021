package com.internship.tvseries.data.repository.config;

import com.internship.tvseries.data.model.Configuration;

import java.util.function.Consumer;

public class ConfigBackendRepository implements ConfigRepository {

    private static ConfigBackendRepository instance = null;

    private ConfigBackendRepository(){}

    public static ConfigBackendRepository getInstance() {
        if (instance == null)
            instance = new ConfigBackendRepository();
        return instance;
    }

    @Override
    public void getConfig(Consumer<Configuration> consumer) {
        //TODO implement method
        consumer.accept(null);
    }
}
