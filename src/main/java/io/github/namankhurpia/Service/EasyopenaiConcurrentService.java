package io.github.namankhurpia.Service;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.Exception.InvalidSizeException;
import io.github.namankhurpia.Interfaces.ConcurrentApiInterface;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionRequestList;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionResponseList;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class EasyopenaiConcurrentService implements ConcurrentApiInterface {

    private static Logger LOGGER = LoggerFactory.getLogger(EasyopenaiConcurrentService.class);


    @Override
    public ModerationResponseList CallMultipleModerationAPI(String key, ModerationRequestList requestList) {
        int n = requestList.size();
        if(n<=0)
        {
            throw new InvalidSizeException("Moderation Request List must have atleast 1 instance",new Throwable());
        }

        List<CompletableFuture<ModerationAPIResponse>> futures = new ArrayList<>();
        EasyopenaiAsyncService AsyncObj = new EasyopenaiAsyncService(new AsyncDAOImpl());

        for(int i=0;i<n;i++)
        {
            int index = i;
            CompletableFuture<ModerationAPIResponse> resultFuture = CompletableFuture.supplyAsync(() ->{
                try {
                    return  AsyncObj.getASyncModeration(OPENAI_KEY,requestList.get(index));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



            });

            futures.add(resultFuture);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));


        try {
            allOf.get(); // Wait for all CompletableFuture instances to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Process the results
        List<ModerationAPIResponse> results = new ArrayList<>();
        for (CompletableFuture<ModerationAPIResponse> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        ModerationResponseList responseList =  new ModerationResponseList(new ArrayList<ModerationAPIResponse>());
        // Handle the combined result or individual results as needed
        responseList.addAll(results);
        return responseList;
    }

    @Override
    public ChatCompletionResponseList CallMultipleChatCompletionAPI(String key, ChatCompletionRequestList requestList) {
        int n = requestList.size();
        if(n<=0)
        {
            throw new InvalidSizeException("Chat Completion Request List must have atleast 1 instance",new Throwable());
        }

        List<CompletableFuture<ChatCompletionResponse>> futures = new ArrayList<>();
        EasyopenaiAsyncService AsyncObj = new EasyopenaiAsyncService(new AsyncDAOImpl());

        for(int i=0;i<n;i++)
        {
            int index = i;

            CompletableFuture<ChatCompletionResponse> resultFuture = CompletableFuture.supplyAsync(() ->{
                try {
                    return  AsyncObj.getAsyncChatCompletion(OPENAI_KEY,requestList.get(index));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



            });

            futures.add(resultFuture);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));


        try {
            allOf.get(); // Wait for all CompletableFuture instances to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Process the results
        List<ChatCompletionResponse> results = new ArrayList<>();
        for (CompletableFuture<ChatCompletionResponse> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        ChatCompletionResponseList responseList =  new ChatCompletionResponseList(new ArrayList<ChatCompletionResponse>());
        // Handle the combined result or individual results as needed
        responseList.addAll(results);
        return responseList;
    }

    @Override
    public ChatCompletionResponseList CallMultipleChatCompletionAPI(ArrayList<String> keyList, ChatCompletionRequestList requestList) {

        int n = requestList.size();
        if(n<=0)
        {
            throw new InvalidSizeException("Chat Completion Request List must have atleast 1 instance",new Throwable());
        }
        int keyListSize = keyList.size();
        if(keyListSize<=0)
        {
            throw new InvalidSizeException("Atleast one key must be added to keylist",new Throwable());
        }


        List<CompletableFuture<ChatCompletionResponse>> futures = new ArrayList<>();
        EasyopenaiAsyncService AsyncObj = new EasyopenaiAsyncService(new AsyncDAOImpl());


        for(int i=0;i<n;i++)
        {
            int index = i;
            //managing key supplies in a round robin fashion
            int keyindex = i % keyListSize;
            String key = keyList.get(keyindex);

            LOGGER.info("Making req:"+ requestList.get(index) + " with key"+ key );

            CompletableFuture<ChatCompletionResponse> resultFuture = CompletableFuture.supplyAsync(() ->{
                try {
                    return  AsyncObj.getAsyncChatCompletion(key,requestList.get(index));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



            });

            futures.add(resultFuture);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));


        try {
            allOf.get(); // Wait for all CompletableFuture instances to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Process the results
        List<ChatCompletionResponse> results = new ArrayList<>();
        for (CompletableFuture<ChatCompletionResponse> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        ChatCompletionResponseList responseList =  new ChatCompletionResponseList(new ArrayList<ChatCompletionResponse>());
        // Handle the combined result or individual results as needed
        responseList.addAll(results);
        return responseList;

    }

}
