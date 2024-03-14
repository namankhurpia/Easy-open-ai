package io.github.namankhurpia.Documentation;

import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.ChatCompletion.Message;
import io.github.namankhurpia.Service.EasyopenaiService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IssueSolving {

    public static void main(String[] args) throws IOException {

        usingTopp();
    }

    public static void usingTopp() throws IOException {
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
                .temperature(1.0d)
                .topP(1.0d)
                .build();

        ChatCompletionResponse response = new EasyopenaiService(new DAOImpl()).chatCompletion(keys.get(0),request);
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
