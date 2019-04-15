package mz.com.xavier.meshop;

import mz.com.xavier.meshop.config.property.MeshopProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MeshopProperty.class)
public class MeshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeshopApplication.class, args);
	}

}
