package io.github.namankhurpia.DAO;

import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Exception.MalformedRequestException;
import io.github.namankhurpia.Interfaces.AsyncApiInterface;
import io.github.namankhurpia.Interfaces.apiInterface;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Exception.ParameterCheckers.checkParamForModeration;

public class AsyncDAOImpl implements AsyncApiInterface {

    ModerationAPIResponse moderationAPIResponseObj;

    CompletionResponse completionResponseObj;

    ChatCompletionResponse chatCompletionResponseObj;
    private static Logger LOGGER = LoggerFactory.getLogger(AsyncDAOImpl.class);

    apiInterface apiInterfaceObj ;



    @Override
    public ModerationAPIResponse getASyncmoderation(String accessToken, ModerationAPIRequest request) throws IOException, ExecutionException, InterruptedException {
        // Param checking
        if (checkParamForModeration(request)) {
            throw new MalformedRequestException("Request object has Model name empty or Input empty ", new Throwable());
        }

        apiInterfaceObj = APIClient.getClient().create(io.github.namankhurpia.Interfaces.apiInterface.class);
        LOGGER.info("Making request " + accessToken + " with request " + request.toString());


        CompletableFuture<ModerationAPIResponse> future = new CompletableFuture<>();

        Call<ModerationAPIResponse> call = apiInterfaceObj.getModeration("Bearer "+accessToken, request);

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
                    System.out.println("HTTP Status Code: " + httpStatusCode);
                    System.out.println("Error Body: " + errorBody.toString());
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
}
