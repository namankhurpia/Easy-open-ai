package com.namankhurpia.openai.openaibackend.Interfaces;

import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.io.IOException;

public interface DaoInterface {

    //input and model are mandatory fields
    ModerationAPIResponse getmoderation(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException;

    //model and prompt are mandatory fields
    CompletionResponse getCompletion(@Header("Authorization")String accessToken, @Body CompletionRequest request) throws IOException;

    //model , message (role and content) are mandatory fields
    ChatCompletionResponse chatCompletion(@Header("Authorization") String accessToken, @Body ChatCompletionRequest request) throws  IOException;


}
