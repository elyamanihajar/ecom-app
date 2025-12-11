package ma.emsi.bot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Component
public class AiAgent {
    private final ChatClient chatClient;

    public AiAgent (ChatClient.Builder builder, ChatMemory memory, ToolCallbackProvider tools) {
        Arrays.stream(tools.getToolCallbacks()).forEach(toolCallback -> {
            System.out.println("-------------------------");
            System.out.println(toolCallback.getToolDefinition());
            System.out.println("----------------------");
        });
        this.chatClient = builder
                .defaultSystem("""
                        Vous êtes un assistant qui se charge de répondre aux questions de l'utilisateur
                        en fonction du contexte fourni.
                        Utilisez les outils mis à votre disposition pour répondre aux questions.
                        Si aucun contexte n'est fourni, répond avec JE ME SAIS PAS.
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(memory).build())
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultToolCallbacks(tools)
                .build();
    }

    public String askAgent(String query) {
        return chatClient.prompt()
                .user(query)
                .call().content();
    }
}
