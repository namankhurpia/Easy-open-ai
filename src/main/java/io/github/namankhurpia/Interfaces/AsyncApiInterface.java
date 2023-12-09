package io.github.namankhurpia.Interfaces;

import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Vision.VisionApiRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface AsyncApiInterface {

    //Moderation API to classify the input text
    ModerationAPIResponse getASyncModeration(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException, ExecutionException, InterruptedException;

    ChatCompletionResponse getAsyncChatCompletion(@Header("Authorization")String accessToken, @Body ChatCompletionRequest request)throws IOException, ExecutionException, InterruptedException;

    VisionApiResponse getAsyncVisionAPI(@Header("Authorization")String accessToken, @Body VisionApiRequest request)throws IOException, ExecutionException, InterruptedException;


}
