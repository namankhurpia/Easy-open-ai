package io.github.namankhurpia.Documentation;

import io.github.namankhurpia.Pojo.ChatCompletion.Message;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionRequestList;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionResponseList;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;
import io.github.namankhurpia.Service.EasyopenaiConcurrentService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class RunnerForConcurrent {
    public static void main(String[] args) {

        CallMultipleChatCompletionAPI_multikey_Test();

    }

    public static void CallMultipleConcurrentAPI_Test()
    {
        /**
         * Moderation Concurrent call
         */

        ModerationAPIRequest request = new ModerationAPIRequest();
        request.setInput("kill me now");
        request.setModel("text-moderation-latest");

        ModerationAPIRequest request2 = new ModerationAPIRequest();
        request2.setInput("hurray me now");
        request2.setModel("text-moderation-latest");

        ModerationAPIRequest request3 = new ModerationAPIRequest();
        request3.setInput("yippee me now");
        request3.setModel("text-moderation-latest");

        ModerationAPIRequest request4 = new ModerationAPIRequest();
        request4.setInput("KILL me now");
        request4.setModel("text-moderation-latest");

        ModerationRequestList requestList = new ModerationRequestList(new ArrayList<ModerationAPIRequest>());
        requestList.add(request);
        requestList.add(request2);
        requestList.add(request3);
        requestList.add(request4);


        EasyopenaiConcurrentService concurrentCalls = new EasyopenaiConcurrentService();
        ModerationResponseList responseList = concurrentCalls.CallMultipleModerationAPI(OPENAI_KEY,requestList);
        System.out.println(responseList);

    }

    public static void CallMultipleChatCompletionAPI_Test()
    {
        /**
         * Chat completion Multiple requests
         */
        ChatCompletionRequestList list = new ChatCompletionRequestList(new ArrayList<ChatCompletionRequest>());

        ChatCompletionRequest requestchat = new ChatCompletionRequest();
        requestchat.setModel("gpt-3.5-turbo");
        Message message = new Message();
        message.setRole("user");
        message.setContent("what is the capital of India?");
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        requestchat.setMessages(messages);
        list.add(requestchat);


        ChatCompletionRequest requestchat2 = new ChatCompletionRequest();
        requestchat2.setModel("gpt-3.5-turbo");
        Message message2 = new Message();
        message2.setRole("user");
        message2.setContent("what is the capital of combodia?");
        List<Message> messages2 = new ArrayList<>();
        messages2.add(message2);
        requestchat2.setMessages(messages2);
        list.add(requestchat2);


        ChatCompletionRequest requestchat3 = new ChatCompletionRequest();
        requestchat3.setModel("gpt-3.5-turbo");
        Message message3 = new Message();
        message3.setRole("user");
        message3.setContent("what is the capital of new zealand?");
        List<Message> messages3 = new ArrayList<>();
        messages3.add(message3);
        requestchat3.setMessages(messages3);
        list.add(requestchat3);


        ChatCompletionRequest requestchat4 = new ChatCompletionRequest();
        requestchat4.setModel("gpt-3.5-turbo");
        Message message4 = new Message();
        message4.setRole("user");
        message4.setContent("what is the capital of hawaii? and what is 2+2?");
        List<Message> messages4 = new ArrayList<>();
        messages4.add(message4);
        requestchat4.setMessages(messages4);
        list.add(requestchat4);

        EasyopenaiConcurrentService concurrentCalls = new EasyopenaiConcurrentService();

        ChatCompletionResponseList responseList = concurrentCalls.CallMultipleChatCompletionAPI(OPENAI_KEY, list);
        System.out.println(responseList);
    }

    public static void CallMultipleChatCompletionAPI_multikey_Test()
    {
        ArrayList<String> keyList = readKeys();
        EasyopenaiConcurrentService concurrentCalls = new EasyopenaiConcurrentService();

        ChatCompletionRequestList list = new ChatCompletionRequestList(new ArrayList<ChatCompletionRequest>());

        ChatCompletionRequest requestchat = new ChatCompletionRequest();
        requestchat.setModel("gpt-3.5-turbo");
        Message message = new Message();
        message.setRole("user");
        message.setContent("what is the capital of India?");
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        requestchat.setMessages(messages);
        list.add(requestchat);


        ChatCompletionRequest requestchat2 = new ChatCompletionRequest();
        requestchat2.setModel("gpt-3.5-turbo");
        Message message2 = new Message();
        message2.setRole("user");
        message2.setContent("what is the capital of combodia?");
        List<Message> messages2 = new ArrayList<>();
        messages2.add(message2);
        requestchat2.setMessages(messages2);
        list.add(requestchat2);


        ChatCompletionRequest requestchat3 = new ChatCompletionRequest();
        requestchat3.setModel("gpt-3.5-turbo");
        Message message3 = new Message();
        message3.setRole("user");
        message3.setContent("what is the capital of new zealand?");
        List<Message> messages3 = new ArrayList<>();
        messages3.add(message3);
        requestchat3.setMessages(messages3);
        list.add(requestchat3);


        ChatCompletionRequest requestchat4 = new ChatCompletionRequest();
        requestchat4.setModel("gpt-3.5-turbo");
        Message message4 = new Message();
        message4.setRole("user");
        message4.setContent("what is the capital of hawaii? and what is 2+2?");
        List<Message> messages4 = new ArrayList<>();
        messages4.add(message4);
        requestchat4.setMessages(messages4);
        list.add(requestchat4);



        ChatCompletionResponseList responseList = concurrentCalls.CallMultipleChatCompletionAPI(keyList, list);
        System.out.println("response is"+responseList);
    }

    public static ArrayList<String> readKeys()
    {
        String filePath = "keys.txt";
        ArrayList<String> keyList = new ArrayList<>();

        // Open the file using Scanner
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Read each line and extract keys
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Assuming each line contains a key
                keyList.add(line);
                //System.out.println("Key: " + line);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return keyList;
    }
}
