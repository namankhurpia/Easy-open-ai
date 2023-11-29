package io.github.namankhurpia.DAO;

import io.github.namankhurpia.Exception.MalformedRequestException;
import io.github.namankhurpia.Interfaces.DaoInterface;
import io.github.namankhurpia.Interfaces.RetrofitApiInterface;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionRequest;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.*;

import java.io.IOException;

import static io.github.namankhurpia.Validators.ParameterCheckers.*;


public class DAOImpl implements DaoInterface {
    ModerationAPIResponse moderationAPIResponseObj;
    CompletionResponse completionResponseObj;

    ChatCompletionResponse chatCompletionResponseObj;
    private static Logger LOGGER = LoggerFactory.getLogger(DAOImpl.class);

    RetrofitApiInterface retrofitApiInterfaceObj;



    @Override
    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {


        // Param checking
        if (checkParamForModeration(request)) {
            throw new MalformedRequestException("Request object has Model name empty or Input empty ", new Throwable());
        }

        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("Making request " + accessToken + " with request " + request.toString());


        Call<ModerationAPIResponse> call = retrofitApiInterfaceObj.getModeration("Bearer "+accessToken, request);

        try {
            Response<ModerationAPIResponse> response = call.execute();

            if (response.isSuccessful()) {
                moderationAPIResponseObj = response.body();
                System.out.println(moderationAPIResponseObj.toString());
            } else {
                int httpStatusCode = response.code();
                String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
                System.out.println("HTTP Status Code: " + httpStatusCode);
                System.out.println("Error Body: " + errorBody.toString());
                throw new MalformedRequestException(errorBody, new Throwable(errorBody));
            }
        } catch (IOException e) {
            // Handle IO exception
            System.out.println("IOException: " + e.getMessage());
            throw e;
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

            retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);

            LOGGER.info("making req" + accessToken + " with request "+ request.toString());
            Call<CompletionResponse> call = retrofitApiInterfaceObj.getCompletion("Bearer "+accessToken,request);
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

            retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);

            LOGGER.info("making req" + accessToken + " with request "+ request.toString());
            Call<ChatCompletionResponse> call = retrofitApiInterfaceObj.chatCompletion("Bearer "+accessToken,request);
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
