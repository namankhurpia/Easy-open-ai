package com.namankhurpia.openai.openaibackend.Interfaces;

import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import retrofit2.http.Body;
import retrofit2.http.Header;

import java.io.IOException;

public interface DaoInterface {

    ModerationAPIResponse getmoderation(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException;

    CompletionResponse getCompletion(@Header("Authorization")String accessToken, @Body CompletionRequest request) throws IOException;

}
