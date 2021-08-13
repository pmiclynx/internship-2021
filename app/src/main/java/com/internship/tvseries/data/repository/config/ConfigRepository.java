package com.internship.tvseries.data.repository.config;

import com.internship.tvseries.data.model.Configuration;

import java.util.function.Consumer;

public interface ConfigRepository {
    void getConfig(Consumer<Configuration> consumer);
}
