package io.github.namankhurpia;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatMessage;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Service.EasyopenaiAsyncService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class RunnerForAsync {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        /**
         * Asynchronous chat
         */

        EasyopenaiAsyncService easyopenaiAsyncService_chat = new EasyopenaiAsyncService(new AsyncDAOImpl());

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("what is the capital of combodia?");

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(chatMessage);

        ChatCompletionRequest request_chat = new ChatCompletionRequest();
        request_chat.setModel("gpt-3.5-turbo");
        request_chat.setMessages(messages); //old conversations as well
        ChatCompletionResponse response_chat = easyopenaiAsyncService_chat.getAsyncChatCompletion(OPENAI_KEY,request_chat);

        /**
         * Asynchronous moderation
         */

        EasyopenaiAsyncService easyopenaiAsyncService_mod = new EasyopenaiAsyncService(new AsyncDAOImpl());

        ModerationAPIRequest request_mod = new ModerationAPIRequest();
        request_mod.setInput("kill me now");
        request_mod.setModel("text-moderation-latest");

        ModerationAPIResponse response_mod =  easyopenaiAsyncService_mod.getASyncModeration(OPENAI_KEY,request_mod);



    }
}
