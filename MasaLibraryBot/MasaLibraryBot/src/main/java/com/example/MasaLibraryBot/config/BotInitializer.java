package com.example.MasaLibraryBot.config;

import com.example.MasaLibraryBot.service.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInitializer {
    @Autowired

    TelegramBot bot;

    @EventListener({ContextClosedEvent.class})
public void init() throws TelegramApiException{
        TelegramBotsApi telegramBotApi = new  TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotApi.registerBot(bot);
        }
        catch (TelegramApiException e){

        }
    }

}
