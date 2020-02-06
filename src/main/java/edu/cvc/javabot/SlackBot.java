package edu.cvc.javabot;

import me.ramswaroop.jbot.core.slack.Bot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SlackBot extends Bot {

    @Value("${slackBotToken}")
    private String slackToken;


    @Override
    public String getSlackToken() {
	return this.slackToken;
    }

    @Override
    public Bot getSlackBot() {
	return this;
    }

}
