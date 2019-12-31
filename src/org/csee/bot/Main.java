package org.csee.bot;

import javax.security.auth.login.LoginException;

public class Main {
    private static final String BOT_KEY = "token";
    public static void main(String[] args) throws LoginException  {
        Bot bot = new Bot(BOT_KEY);
        bot.start();
    }
}
