package com.namankhurpia.openai.openaibackend.DAO;

import com.namankhurpia.openai.openaibackend.Interfaces.DaoInterface;
import com.namankhurpia.openai.openaibackend.Interfaces.apiInterface;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import retrofit2.*;

import java.io.IOException;

@Service
public class DAOImpl implements DaoInterface {


    apiInterface apiInterfaceObj;
    private static Logger LOGGER = LoggerFactory.getLogger(DAOImpl.class);
    ModerationAPIResponse moderationAPIResponseObj;
    CompletionResponse completionResponseObj;

    ChatCompletionResponse chatCompletionResponseObj;

    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {


        apiInterfaceObj = APIClient.getClient().create(com.namankhurpia.openai.openaibackend.Interfaces.apiInterface.class);
        //LOGGER.info("making req" + accessToken + " with request "+ request.toString());
        Call<ModerationAPIResponse> call = (Call<ModerationAPIResponse>) apiInterfaceObj.getModeration(accessToken, request);
        Response<ModerationAPIResponse> response = call.execute();

        if (response.isSuccessful()) {
            moderationAPIResponseObj = response.body();
            LOGGER.info(moderationAPIResponseObj.toString());
        }
        else
        {
            LOGGER.error(response.errorBody().toString());
        }

        return moderationAPIResponseObj;


    }

    @Override
    public CompletionResponse getCompletion(String accessToken, CompletionRequest request) throws IOException {
        apiInterfaceObj = APIClient.getClient().create(apiInterface.class);
        LOGGER.info("making req" + accessToken + " with request "+ request.toString());
        Call<CompletionResponse> call = apiInterfaceObj.getCompletion(accessToken,request);
        Response<CompletionResponse> response = call.execute();

        if(response.isSuccessful())
        {
            completionResponseObj = response.body();
            LOGGER.info("Correct response" + completionResponseObj.toString());
        }
        else
        {
            int httpStatusCode = response.code();
            String errorBody = response.errorBody() != null ? response.errorBody().string() : "Empty error body";
            LOGGER.error("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBody);

            // You may want to throw a custom exception or log the error based on your needs
            //throw new YourCustomException("API call was not successful");
        }

        return  completionResponseObj;
    }

    @Override
    public ChatCompletionResponse chatCompletion(String accessToken, ChatCompletionRequest request) throws IOException {
        apiInterfaceObj = APIClient.getClient().create(apiInterface.class);
        LOGGER.info("making req" + accessToken + " with request "+ request.toString());
        Call<ChatCompletionResponse> call = apiInterfaceObj.chatCompletion(accessToken,request);
        Response<ChatCompletionResponse> response = call.execute();

        if(response.isSuccessful())
        {
            chatCompletionResponseObj = response.body();
            LOGGER.info("Correct response" + chatCompletionResponseObj.toString());
        }
        else
        {
            int httpStatusCode = response.code();
            String errorBody = response.errorBody() != null ? response.errorBody().string() : "Empty error body";
            LOGGER.error("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBody);

            // You may want to throw a custom exception or log the error based on your needs
            //throw new YourCustomException("API call was not successful");
        }

        return  chatCompletionResponseObj;
    }


}
