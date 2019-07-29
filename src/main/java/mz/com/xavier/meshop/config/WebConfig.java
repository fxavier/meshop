package mz.com.xavier.meshop.config;

import mz.com.xavier.meshop.storage.ImageStorage;
import mz.com.xavier.meshop.storage.local.ImageStorageLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ImageStorage imageStorage() {
        return new ImageStorageLocal();
    }
}
