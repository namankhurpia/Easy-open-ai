package io.github.namankhurpia.Documentation;

import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.ChatCompletion.Message;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.MyModels.EasyVisionRequest;
import io.github.namankhurpia.Pojo.Speech.EasyTranscriptionRequest;
import io.github.namankhurpia.Pojo.Speech.SpeechRequest;
import io.github.namankhurpia.Pojo.Vision.*;
import io.github.namankhurpia.Service.EasyTranscriptionService;
import io.github.namankhurpia.Service.EasyVisionService;
import io.github.namankhurpia.Service.EasyopenaiService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class RunnerForSingleInstance {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        //runMoDerationSingleInstance();
        //runVisionAPI();
        //runEasyVisionAPI();
        //runEasyVisionAPI2();
        //runEasyMoDerationSingleInstance();
        //runEasyChatCompletionSingleInstance();
        //TestForSpeech();
        //TestForTranscription();
        TestForEasyTranscription();

    }

    public static void runEasyVisionAPI()throws IOException
    {

        /**
         * EASY VISION API
         */
        ArrayList<String> keys = readKeys();
        EasyVisionRequest request = new EasyVisionRequest();
        request.setModel("gpt-4-vision-preview");
        request.setPrompt("What are the difference between these images");

        ArrayList<String> imageurls = new ArrayList<>();
        imageurls.add("https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        imageurls.add("https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        request.setImageUrls(imageurls);

        EasyVisionService obj = new EasyVisionService();
        VisionApiResponse response = obj.VisionAPI(keys.get(0),request);
        System.out.println(response);


    }

    public static void runEasyVisionAPI2()throws IOException
    {
        /**
         * EASY VISION API - ONE LINER
         */
        VisionApiResponse response = new EasyVisionService().VisionAPI(readKeys().get(0), new EasyVisionRequest()
                .setModel("gpt-4-vision-preview")
                .setPrompt("What are the difference between these images")
                .setMaxtokens(300)
                .setImageUrls(new ArrayList<String>() {{
                    add("https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
                    add("https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
                }}));

        System.out.println(response);
    }

    public static void runVisionAPI() throws IOException
    {
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

        System.out.println(request);

        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
        VisionApiResponse res = obj.visionAPI(keys.get(0),request);
        System.out.println("Response is:"+res);




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


    public static void runEasyMoDerationSingleInstance() throws IOException {
        /**
         * Moderation API single
         */
        ArrayList<String> keys = readKeys();

        ModerationAPIRequest request = ModerationAPIRequest.builder()
                .model("text-moderation-latest")
                .input("hello from the other side kill me now")
                .build();

        ModerationAPIResponse res = new EasyopenaiService(new DAOImpl()).getmoderation(keys.get(0),request);
        System.out.println("response is"+ res);


    }


    public static void runChatCompletionSingleInstance() throws IOException{
        /**
         * Chat Completion API single
         */
        ArrayList<String> keys = readKeys();
        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());

        Message message = new Message();
        message.setRole("user");
        message.setContent("what is the capital of combodia?");

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        ChatCompletionRequest request = new ChatCompletionRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(messages); //old conversations as well
        ChatCompletionResponse res = obj.chatCompletion(keys.get(0),request);

    }

    public static void runEasyChatCompletionSingleInstance() throws IOException{
        /**
         * Chat Completion API single
         */
        ArrayList<String> keys = readKeys();

        Message message = Message.builder()
                .role("user")
                .content("what is the capital of Cambodia?")
                .build();

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .build();

        ChatCompletionResponse response = new EasyopenaiService(new DAOImpl()).chatCompletion(keys.get(0),request);
        System.out.println(response);

    }


    public static void TestForSpeech() throws IOException {
        /**
         * Speech generation API single
         */
        ArrayList<String> keys = readKeys();
        SpeechRequest request = SpeechRequest.builder()
                .model("tts-1")
                .input("The quick brown fox jumped over the lazy dog.")
                .voice("alloy")
                .build();

        ResponseBody response = new EasyopenaiService(new DAOImpl()).createSpeech(keys.get(0),request);


    }


    public static void TestForTranscription() throws IOException {
        /**
         * Speech generation API single
         */
        File audioFile = new File("/Users/namankhurpia/Desktop/audio.mp3");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                audioFile.getName(),
                RequestBody.create(MediaType.parse("audio/*"), audioFile)
        );

        ArrayList<String> keys = readKeys();
        RequestBody model = RequestBody.create(MediaType.parse("text/plain"), "whisper-1");
        RequestBody language = RequestBody.create(MediaType.parse("text/plain"), "");
        RequestBody prompt = RequestBody.create(MediaType.parse("text/plain"), "");
        RequestBody response_format = RequestBody.create(MediaType.parse("text/plain"), "");
        RequestBody temperature = RequestBody.create(MediaType.parse("text/plain"), "");

        ResponseBody response = new EasyopenaiService(new DAOImpl()).createTranscriptions(keys.get(0), filePart,model, language,prompt,response_format,temperature);
        System.out.println(response.string());


    }

    public static void TestForEasyTranscription() throws IOException {
        ArrayList<String> keys = readKeys();

        EasyTranscriptionRequest request  = new EasyTranscriptionRequest();
        request.setFilepath("/Users/namankhurpia/Desktop/audio.mp3");
        request.setModel("whisper-1");

        ResponseBody response = new EasyTranscriptionService().EasyTranscription(keys.get(0), request);
        System.out.println(response);
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