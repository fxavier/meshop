package mz.com.xavier.meshop.storage.local;

import mz.com.xavier.meshop.storage.ImageStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class ImageStorageLocal implements ImageStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageStorageLocal.class);

    private Path local;
    private Path localTemporario;

    public ImageStorageLocal() {
        this(FileSystems.getDefault().getPath(System.getenv("HOME"), ".meshopImagens"));
    }

    public ImageStorageLocal(Path path) {
        this.local = path;
        criarPastas();
    }


    @Override
    public String salvar(MultipartFile[] files) {
        String novoNome = null;

        if (files != null && files.length > 0) {
            MultipartFile arquivo = files[0];
            novoNome = renomearArquivo(arquivo.getOriginalFilename());
            try {
                arquivo.transferTo(new File(this.local.toAbsolutePath().toString()
                        + FileSystems.getDefault().getSeparator() + novoNome));
            } catch (IOException e) {
                throw new RuntimeException("Erro ao salvar a imagem", e);
            }
        }
        return novoNome;
    }


    @Override
    public byte[] recuperar(String image) {
        try {
            return Files.readAllBytes(this.local.resolve(image));
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo a imagem");
        }
    }

    @Override
    public void excluir(String image) {
        try {
            Files.deleteIfExists(this.local.resolve(image));

        } catch (IOException e) {
            LOGGER.warn("Erro apagando a foto '%s'. Mensagem: %s ", image, e.getMessage());
        }

    }

    @Override
    public String getUrl(String image) {
        return "http://localhost:8080/images";
    }

    private void criarPastas() {
        try {
            Files.createDirectories(this.local);
            this.localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp");
            Files.createDirectories(this.localTemporario);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Pastas criadas para salvar imagens");
                LOGGER.debug("Pasta default:" + this.local.toAbsolutePath());
                LOGGER.debug("Pasta temporária:" + this.localTemporario.toAbsolutePath());
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro criando pasta para salvar imagem");

        }
    }


}
