package org.csee.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    private String token;

    public Bot(String token) {
        this.token = token;
    }

    public void start() throws LoginException {
        new JDABuilder(token)
                .setActivity(Activity.playing("Test"))
                .build();
    }
}
