package com.example.MasaLibraryBot.config;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("application.properties")
public class BotConfig {

    @Value("${bot.name}")
    String boName;
    @Value("${bot.token}")
    String token;
}
