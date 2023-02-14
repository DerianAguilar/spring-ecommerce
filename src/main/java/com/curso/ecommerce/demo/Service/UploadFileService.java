package com.curso.ecommerce.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {

    private String folder="image//";

    public String saveImage(MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            byte[] bytes=file.getBytes();
            Path path = Paths.get(folder+file.getOriginalFilename());
            Files.write(path,bytes);

            return file.getOriginalFilename();
        }

        return "default.jpg";
    }

    public void delete(String nombre){
        String ruta = "image//";
        File file = new File(ruta+nombre);

        file.delete();
    }

}
