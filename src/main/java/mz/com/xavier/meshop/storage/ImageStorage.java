package mz.com.xavier.meshop.storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageStorage {

    public String salvar(MultipartFile[] files);

    public byte[] recuperar(String image);

    public void excluir(String image);

    public String getUrl(String image);

    default String renomearArquivo(String nomeOriginal) {
        return UUID.randomUUID().toString() + "_" + nomeOriginal;
    }

}
