package mz.com.xavier.meshop.storage;

import lombok.Data;
import mz.com.xavier.meshop.dto.ImagemDTO;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageStorageRunnable implements Runnable {

    private MultipartFile[] files;
    private DeferredResult<ImagemDTO> resultado;
    private ImageStorage imageStorage;

    public ImageStorageRunnable(MultipartFile[] files, DeferredResult<ImagemDTO> resultado, ImageStorage imageStorage) {
        this.files = files;
        this.resultado = resultado;
        this.imageStorage = imageStorage;
    }

    @Override
    public void run() {

        String nomeImagem = this.imageStorage.salvar(files);
        String contentType = files[0].getContentType();
        resultado.setResult(new ImagemDTO(nomeImagem, contentType, imageStorage.getUrl(nomeImagem)));
    }
}
