package com.devstudios.dbu.devstudios_dbu.domain.exceptions;





public class CustomException extends RuntimeException {

    private String error;
    private int status;

    private CustomException( String error, int status ){
        super(error);
        this.error = error;
        this.status = status;
    }


    public static CustomException BadRequestException( String error ){
        return new CustomException(error, 400);
    }

    public static CustomException NotFoundException( String error ){
        return new CustomException(error, 404);
    }

    public static CustomException InternalServerError( String error ){
        System.out.println(error);
        return new CustomException("Unexpected error, try again later.", 500);
    }




    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
