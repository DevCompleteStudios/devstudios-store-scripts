package com.devstudios.dbu.devstudios_dbu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@EnableAsync
@PropertySource("classpath:mailer.properties")
public class MailerConfig {}
