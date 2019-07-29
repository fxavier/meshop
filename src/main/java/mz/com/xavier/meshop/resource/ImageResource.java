package mz.com.xavier.meshop.resource;

import mz.com.xavier.meshop.dto.ImagemDTO;
import mz.com.xavier.meshop.storage.ImageStorage;
import mz.com.xavier.meshop.storage.ImageStorageRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageResource {

    @Autowired
    private ImageStorage imageStorage;

    @PostMapping
    public DeferredResult<ImagemDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
        DeferredResult<ImagemDTO> resultado = new DeferredResult<>();

        Thread thread = new Thread(new ImageStorageRunnable(files, resultado, imageStorage));
        thread.start();

        return resultado;
    }
}
