package mz.com.xavier.meshop.config.property;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("meshop")
public class MeshopProperty {

    @Getter
    @Setter
    private String originPermitida = "http://localhost:4200";

    @Getter
    private  final Seguranca seguranca = new Seguranca();

    @Data
    public static class Seguranca {
        private boolean enableHttps;

    }

}
