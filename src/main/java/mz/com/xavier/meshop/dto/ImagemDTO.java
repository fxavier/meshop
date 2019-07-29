package mz.com.xavier.meshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ImagemDTO {

    private String nome;
    private String contentType;
    private String url;


    public ImagemDTO(String nome, String contentType, String url) {
        this.nome = nome;
        this.contentType = contentType;
        this.url = url;
    }
}
