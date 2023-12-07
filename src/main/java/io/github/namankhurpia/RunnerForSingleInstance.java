package io.github.namankhurpia;

import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatMessage;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Service.EasyopenaiService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class RunnerForSingleInstance {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        runMoDerationSingleInstance();
    }



    public static void runMoDerationSingleInstance() throws IOException {
        /**
         * Moderation API single
         */
        ArrayList<String> keys = readKeys();
        ModerationAPIRequest request = new ModerationAPIRequest();
        request.setInput("hello from the other side kill me now");
        request.setModel("text-moderation-latest");

        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
        ModerationAPIResponse res =  obj.getmoderation(keys.get(0),request);
        System.out.println("response is"+ res);


    }

    public static void runChatCompletionSingleInstance() throws IOException{
        /**
         * Chat Completion API single
         */
        ArrayList<String> keys = readKeys();
        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("what is the capital of combodia?");

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(chatMessage);

        ChatCompletionRequest request = new ChatCompletionRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(messages); //old conversations as well
        ChatCompletionResponse res = obj.chatCompletion(keys.get(0),request);

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