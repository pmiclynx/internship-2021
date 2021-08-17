package com.internship.tvseries.data.repository.config;

import com.internship.tvseries.data.model.Configuration;
import com.internship.tvseries.data.model.Images;
import com.internship.tvseries.utils.Constants;

import java.util.function.Consumer;

public class LynxConfigRepository implements ConfigRepository {

    private static LynxConfigRepository instance = null;

    private LynxConfigRepository() {}

    public static synchronized LynxConfigRepository getInstance() {
        if (instance == null)
            instance = new LynxConfigRepository();
        return instance;
    }

    @Override
    public void getConfig(Consumer<Configuration> consumer) {
        Configuration configuration = new Configuration();
        configuration.setImages(new Images());
        configuration.getImages().setBaseUrl(Constants.LYNX_BASE_URL.substring(0, Constants.LYNX_BASE_URL.length()-4));
        consumer.accept(configuration);
    }
}
