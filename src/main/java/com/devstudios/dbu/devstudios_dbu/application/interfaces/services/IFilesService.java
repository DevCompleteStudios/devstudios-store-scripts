package com.devstudios.dbu.devstudios_dbu.application.interfaces.services;

import org.springframework.web.multipart.MultipartFile;

import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;



public interface IFilesService {

    public String upload( MultipartFile file, String path );
    public String delete( String url, String path );
    public default String update( String url, MultipartFile file, String path ){
        try {
            delete(url, path);
            return upload(file, path);
        } catch (Exception e) {
            throw CustomException.InternalServerError(e.getMessage());
        }
    }

}
