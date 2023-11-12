package com.namankhurpia.openai.openaibackend.Interfaces;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.io.IOException;


public interface apiInterface {

    @POST("/v1/moderations")
    Call<ModerationAPIResponse> getmoderation(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException;


}
