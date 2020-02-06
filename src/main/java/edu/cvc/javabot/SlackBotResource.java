package edu.cvc.javabot;

import me.ramswaroop.jbot.core.common.Controller;
import me.ramswaroop.jbot.core.common.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

@RestController
public class SlackBotResource extends SlackBot {

    @Controller(events = {EventType.MESSAGE}, pattern = "hello") public void audit(WebSocketSession session, Event event) {
	reply(session, event, new Message("hello"));
    }

}
