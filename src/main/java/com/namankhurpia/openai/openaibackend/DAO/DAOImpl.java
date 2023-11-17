package com.namankhurpia.openai.openaibackend.DAO;

import com.namankhurpia.openai.openaibackend.Exception.MalformedRequestException;
import com.namankhurpia.openai.openaibackend.Exception.ParameterCheckers;
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

import static com.namankhurpia.openai.openaibackend.Exception.ParameterCheckers.*;

@Service
public class DAOImpl implements DaoInterface {


    apiInterface apiInterfaceObj;
    private static Logger LOGGER = LoggerFactory.getLogger(DAOImpl.class);
    ModerationAPIResponse moderationAPIResponseObj;
    CompletionResponse completionResponseObj;

    ChatCompletionResponse chatCompletionResponseObj;

    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {

        //param checking
        if(checkParamForModeration(request))
        {
            throw new MalformedRequestException("Request object has Model name empty or Input empty ", new Throwable());
        }

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
            int httpStatusCode = response.code();
            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            LOGGER.error(response.errorBody().toString());
            throw new MalformedRequestException(errorBody, new Throwable(errorBody));
        }

        return moderationAPIResponseObj;


    }

    @Override
    public CompletionResponse getCompletion(String accessToken, CompletionRequest request) throws IOException {

        //param checking
        if(checkParamForCompletion(request))
        {
            throw new MalformedRequestException("Request object has Model name empty or promp empty ", new Throwable());
        }

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
            throw new MalformedRequestException(errorBody, new Throwable(errorBody));
        }

        return  completionResponseObj;
    }

    @Override
    public ChatCompletionResponse chatCompletion(String accessToken, ChatCompletionRequest request) throws IOException {


        //param checking
        if(checkParamForChatCompletion_Messages_role_content(request))
        {
            throw new MalformedRequestException("messages Object has either role or content Empty", new Throwable());
        }
        if(checkParamForChatCompletion_modelName(request))
        {
            throw new MalformedRequestException("Request object has Model name empty, please specify a model you wish to use", new Throwable());
        }

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
            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            LOGGER.error("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBody);
            throw new MalformedRequestException(errorBody, new Throwable(errorBody));

        }




        return  chatCompletionResponseObj;
    }


}
