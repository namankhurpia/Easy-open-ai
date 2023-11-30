package io.github.namankhurpia;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class RunnerForSingleInstance {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        System.out.println("Hello world!");

        /**
         * Moderation API single
         */
        /*
        ModerationAPIRequest request = new ModerationAPIRequest();
        request.setInput("kill me now");
        request.setModel("text-moderation-latest");

        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
        ModerationAPIResponse res =  obj.getmoderation(OPENAI_KEY,request);
        */

        /**
         * Chat Completion API single
         */
        /*
        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("what is the capital of combodia?");

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(chatMessage);

        ChatCompletionRequest request = new ChatCompletionRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(messages); //old conversations as well
        ChatCompletionResponse res = obj.chatCompletion(OPENAI_KEY,request);
        */





    }
}