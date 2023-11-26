package io.github.namankhurpia.Service;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.Exception.InvalidSizeException;
import io.github.namankhurpia.Interfaces.ConcurrentApiInterface;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionRequestList;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionResponseList;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class ConcurrentAPIServiceImpl implements ConcurrentApiInterface {


    @Override
    public ModerationResponseList CallMultipleModerationAPI(String key, ModerationRequestList requestList) {
        int n = requestList.getRequestList().size();
        if(n<=0)
        {
            throw new InvalidSizeException("Moderation Request List must have atleast 1 instance",new Throwable());
        }

        List<CompletableFuture<ModerationAPIResponse>> futures = new ArrayList<>();
        AsyncModerationAPIServiceImpl AsyncObj = new AsyncModerationAPIServiceImpl(new AsyncDAOImpl());

        for(int i=0;i<n;i++)
        {
            int index = i;
            CompletableFuture<ModerationAPIResponse> resultFuture = CompletableFuture.supplyAsync(() ->{
                try {
                    return  AsyncObj.getASyncmoderation(OPENAI_KEY,requestList.getRequestList().get(index));
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
        return null;
    }
}
