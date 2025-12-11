package ma.emsi.bot.web;

import ma.emsi.bot.agents.AiAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
@CrossOrigin("*")
public class ChatController {
    private AiAgent agent;

    public ChatController(AiAgent agent) {
        this.agent = agent;
    }

    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(String query) {
        return agent.askAgent(query);
    }
}
