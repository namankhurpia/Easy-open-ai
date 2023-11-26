package io.github.namankhurpia.Interfaces;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionRequest;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.io.IOException;


public interface apiInterface {

    //Moderation API to classify the input text
    @POST("/v1/moderations")
    Call<ModerationAPIResponse> getModeration(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException;


    //Newer models (2023–) gpt-4 (and gpt-4 turbo), gpt-3.5-turbo
    @POST("/v1/completions")
    Call<CompletionResponse> getCompletion(@Header("Authorization")String accessToken, @Body CompletionRequest request)throws IOException;

    //Updated base models (2023) babbage-002, davinci-002 and Legacy models (2020–2022) text-davinci-003, text-davinci-002, davinci, curie, babbage, ada
    @POST("/v1/completions")
    Call<CompletionResponse> completion_old(@Header("Authorization")String accessToken, @Body CompletionRequest request)throws IOException;


    @POST("/v1/chat/completions")
    Call<ChatCompletionResponse> chatCompletion(@Header("Authorization") String accessToken, @Body ChatCompletionRequest request) throws  IOException;


}
