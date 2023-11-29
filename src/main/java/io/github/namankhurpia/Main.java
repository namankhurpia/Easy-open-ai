package io.github.namankhurpia;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatMessage;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Service.EasyopenaiAsyncService;
import io.github.namankhurpia.Service.EasyopenaiService;
import io.github.namankhurpia.Service.EasyopenaiConcurrentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class Main {
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


        /**
         * Asynchronous chat
         */
        /*
        EasyopenaiAsyncService obj = new EasyopenaiAsyncService(new AsyncDAOImpl());

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("what is the capital of combodia?");

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(chatMessage);

        ChatCompletionRequest request = new ChatCompletionRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(messages); //old conversations as well
        ChatCompletionResponse res = obj.getAsyncChatCompletion(OPENAI_KEY,request);
*/
        /**
         * Asynchronous moderation
         */
        /*
        ModerationAPIRequest request = new ModerationAPIRequest();
        request.setInput("kill me now");
        request.setModel("text-moderation-latest");

        EasyopenaiAsyncService obj = new EasyopenaiAsyncService(new AsyncDAOImpl());
        ModerationAPIResponse res =  obj.getASyncModeration(OPENAI_KEY,request);
        */



    }
}