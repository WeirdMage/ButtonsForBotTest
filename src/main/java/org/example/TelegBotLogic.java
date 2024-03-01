package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import  java.util.List;


public class TelegBotLogic {
    public void processTextMessageFromUser(String textFromUser, SendMessage messageToUser) {
        String textToUser = "";

        if (textFromUser.equals("/start")){
            textToUser = "маладец, выбери подарок!";

            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            List<InlineKeyboardButton> row;
            InlineKeyboardButton button;

            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText("Рассказать шутку");
            button.setCallbackData("Joke");
            row.add(button);
            keyboard.add(row);

            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText("Прочитать прогноз погоды");
            button.setCallbackData("Weather");
            row.add(button);
            keyboard.add(row);

            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText("Поставить любимую музыку");
            button.setCallbackData("Music");
            row.add(button);
            keyboard.add(row);

            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            inlineKeyboardMarkup.setKeyboard(keyboard);

            messageToUser.setReplyMarkup(inlineKeyboardMarkup);
        }
        else {
            textToUser = "позорище, будь пацаном, напиши /start ";
        }
        messageToUser.setText(textToUser);
    }

    public void processInlineButtonClickFromUser(String textFromUser, SendMessage messageToUser) {
        String textToUser = "";

        if (textFromUser.equals("Joke")) {
            textToUser = "Ебутся два клоуна в вентиляции, а один говорит - что-то нухуя не смешно ";

        } else if (textFromUser.equals("Weather")) {
            textToUser = "Погода как снег - говно";
        } else if (textFromUser.equals("Music")) {
            textToUser = "На слушай https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        }

        messageToUser.setText(textToUser);
    }


}
