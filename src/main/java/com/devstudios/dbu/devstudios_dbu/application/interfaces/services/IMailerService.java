package com.devstudios.dbu.devstudios_dbu.application.interfaces.services;



public interface IMailerService {

    public void sendEmail(String to, String html, String subject);

}
