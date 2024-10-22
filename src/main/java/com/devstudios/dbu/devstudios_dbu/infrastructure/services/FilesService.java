package com.devstudios.dbu.devstudios_dbu.infrastructure.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IFilesService;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IRandomCodes;
import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class FilesService implements IFilesService {

    private final String basePath = "src/main/resources/static/";

    @Autowired
    private IRandomCodes randomCodes;
    @Autowired
    private HttpServletRequest request;


    @Override
    public String upload(MultipartFile file, String path) {
        try {
            String originalFilename = file.getOriginalFilename();
            if( originalFilename == null ) throw CustomException.BadRequestException("File required extension valid.");

            // Si no existe lo creamos
            this.getPath(path);

            String extension = originalFilename.substring(originalFilename.lastIndexOf(".")).trim();
            String fileName = randomCodes.uuid().toString() + extension;

            Path pathFile = Paths.get(basePath + path + fileName);

            Files.write(pathFile, file.getBytes());

            String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();
            String fileUrl = pathFile.toString().substring( (pathFile.toString().lastIndexOf('\\') + 1) );

            var url = baseUrl + "/" + path + fileUrl;
            return url;
        } catch (IOException e) {
            throw CustomException.InternalServerError("No se logro guardar la data");
        }
    }

    @Override
    public String delete(String url, String path) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Path getPath( String path ) throws IOException{
        Path directory = Paths.get(basePath + path);
        if( Files.notExists(directory) ) Files.createDirectories(directory);
        return directory;
    }
}
