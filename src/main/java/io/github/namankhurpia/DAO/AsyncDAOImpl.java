package io.github.namankhurpia.DAO;

import io.github.namankhurpia.Exception.MalformedRequestException;
import io.github.namankhurpia.Interfaces.AsyncApiInterface;
import io.github.namankhurpia.Interfaces.RetrofitApiInterface;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Vision.VisionApiRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Validators.ParameterCheckers.*;

public class AsyncDAOImpl implements AsyncApiInterface {

    ModerationAPIResponse moderationAPIResponseObj;

    CompletionResponse completionResponseObj;

    ChatCompletionResponse chatCompletionResponseObj;

    VisionApiResponse visionApiResponseObj;

    private static Logger LOGGER = LoggerFactory.getLogger(AsyncDAOImpl.class);

    RetrofitApiInterface retrofitApiInterfaceObj;



    @Override
    public ModerationAPIResponse getASyncModeration(String accessToken, ModerationAPIRequest request) throws IOException, ExecutionException, InterruptedException {
        // Param checking
        if (checkParamForModeration(request)) {
            throw new MalformedRequestException("Request object has Model name empty or Input empty ", new Throwable());
        }

        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("Making request " + accessToken + " with request " + request.toString());


        CompletableFuture<ModerationAPIResponse> future = new CompletableFuture<>();

        Call<ModerationAPIResponse> call = retrofitApiInterfaceObj.getModeration("Bearer "+accessToken, request);

        call.enqueue(new Callback<ModerationAPIResponse>() {
            @Override
            public void onResponse(Call<ModerationAPIResponse> call, Response<ModerationAPIResponse> response) {
                if (response.isSuccessful()) {
                    moderationAPIResponseObj = response.body();

                    future.complete(response.body());
                }
                else
                {
                    int httpStatusCode = response.code();
                    String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
                    LOGGER.error("HTTP Status Code: " + httpStatusCode);
                    LOGGER.error("Error Body: " + errorBody.toString());
                    future.completeExceptionally(new MalformedRequestException(errorBody, new Throwable(errorBody)));
                }
            }

            @Override
            public void onFailure(Call<ModerationAPIResponse> call, Throwable throwable) {
                future.completeExceptionally(throwable);
            }
        });



        return future.get();


    }

    @Override
    public ChatCompletionResponse getAsyncChatCompletion(String accessToken, ChatCompletionRequest request) throws IOException, ExecutionException, InterruptedException {
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

        CompletableFuture<ChatCompletionResponse> future = new CompletableFuture<>();

        Call<ChatCompletionResponse> call = retrofitApiInterfaceObj.chatCompletion("Bearer "+accessToken,request);

        call.enqueue(new Callback<ChatCompletionResponse>() {
            @Override
            public void onResponse(Call<ChatCompletionResponse> call, Response<ChatCompletionResponse> response) {
                if(response.isSuccessful())
                {
                    chatCompletionResponseObj = response.body();
                    future.complete(response.body());
                    LOGGER.info("Correct response" + chatCompletionResponseObj.toString());

                }
                else
                {
                    int httpStatusCode = response.code();
                    String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
                    LOGGER.error("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBody);

                    future.completeExceptionally(new MalformedRequestException(errorBody, new Throwable(errorBody)));

                }
            }

            @Override
            public void onFailure(Call<ChatCompletionResponse> call, Throwable throwable) {
                future.completeExceptionally(throwable);
            }



        });




        return  future.get();
    }

    @Override
    public VisionApiResponse getAsyncVisionAPI(String accessToken, VisionApiRequest request) throws IOException, ExecutionException, InterruptedException {

        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);

        LOGGER.info("making req" + accessToken + " with request "+ request.toString());

        CompletableFuture<VisionApiResponse> future = new CompletableFuture<>();

        Call<VisionApiResponse> call = retrofitApiInterfaceObj.visionAPI("Bearer "+accessToken,request);

        call.enqueue(new Callback<VisionApiResponse>() {
            @Override
            public void onResponse(Call<VisionApiResponse> call, Response<VisionApiResponse> response) {
                if(response.isSuccessful())
                {
                    visionApiResponseObj = response.body();
                    future.complete(response.body());
                    LOGGER.info("Correct response" + visionApiResponseObj.toString());

                }
                else
                {
                    int httpStatusCode = response.code();
                    String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
                    LOGGER.error("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBody);

                    future.completeExceptionally(new MalformedRequestException(errorBody, new Throwable(errorBody)));

                }
            }

            @Override
            public void onFailure(Call<VisionApiResponse> call, Throwable throwable) {
                future.completeExceptionally(throwable);
            }



        });




        return  future.get();
    }
}
