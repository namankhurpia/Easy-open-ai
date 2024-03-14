package io.github.namankhurpia.Documentation;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.Pojo.ChatCompletion.Message;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Vision.*;
import io.github.namankhurpia.Service.EasyopenaiAsyncService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class RunnerForAsync {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        RunnerForAsync_chatCompletion();
        RunnerForAsync_ModerationAPI();
        RunnerForAsync_VisionAPI();



    }

    public static  void RunnerForAsync_chatCompletion() throws IOException, ExecutionException, InterruptedException {
        /**
         * Asynchronous chat
         */
        ArrayList<String> keys = readKeys();
        EasyopenaiAsyncService easyopenaiAsyncService_chat = new EasyopenaiAsyncService(new AsyncDAOImpl());

        Message message = new Message();
        message.setRole("user");
        message.setContent("what is the capital of combodia?");

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        ChatCompletionRequest request_chat = new ChatCompletionRequest();
        request_chat.setModel("gpt-3.5-turbo");
        request_chat.setMessages(messages); //old conversations as well
        ChatCompletionResponse response_chat = easyopenaiAsyncService_chat.getAsyncChatCompletion(keys.get(0),request_chat);
        System.out.println(response_chat);
    }

    public static void RunnerForAsync_ModerationAPI() throws IOException, ExecutionException, InterruptedException {
        /**
         * Asynchronous moderation
         */
        ArrayList<String> keys = readKeys();
        EasyopenaiAsyncService easyopenaiAsyncService_mod = new EasyopenaiAsyncService(new AsyncDAOImpl());

        ModerationAPIRequest request_mod = new ModerationAPIRequest();
        request_mod.setInput("kill me now");
        request_mod.setModel("text-moderation-latest");

        ModerationAPIResponse response_mod =  easyopenaiAsyncService_mod.getASyncModeration(keys.get(0),request_mod);
    }

    public static void RunnerForAsync_VisionAPI() throws IOException, ExecutionException, InterruptedException {
            /**
             * Vision API Single Instance
             */
            ArrayList<String> keys = readKeys();
            VisionApiRequest request = new VisionApiRequest();

            ImageUrl url = new ImageUrl();
            url.setUrl("https://images.pexels.com/photos/18907092/pexels-photo-18907092/free-photo-of-a-photo-of-the-golden-gate-bridge-in-the-sky.jpeg");
            url.setDetail("low");

            Content content1 = new Content();
            content1.setText("What’s in this image?");
            content1.setType("text");

            Content content2 = new Content();
            content2.setImageUrl(url);
            content2.setType("image_url");

            ArrayList<Content> listofContent = new ArrayList<>();
            listofContent.add(content1);
            listofContent.add(content2);

            MessageList messageList = new MessageList();
            messageList.setRole("user");
            messageList.setContent(listofContent);

            ArrayList<MessageList> listofMessage= new ArrayList<>();
            listofMessage.add(messageList);

            request.setModel("gpt-4-vision-preview");
            request.setMaxTokens(300);
            request.setMessages(listofMessage);

            EasyopenaiAsyncService easyopenaiAsyncService_mod = new EasyopenaiAsyncService(new AsyncDAOImpl());
            VisionApiResponse res = easyopenaiAsyncService_mod.getAsyncVisionAPI(keys.get(0),request);
            System.out.println("Response is:"+res);



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
