package com.namankhurpia.openai.openaibackend.Service;

import com.namankhurpia.openai.openaibackend.Interfaces.EndPoints;
import com.namankhurpia.openai.openaibackend.Interfaces.ModerationAPI;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Service
public class ModerationService implements EndPoints {

    private ModerationAPI service;

    public ModerationService(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ModerationAPI.class);

    }


    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {
        Call<ModerationAPIResponse> responseCall = (Call<ModerationAPIResponse>) service.getmoderation(accessToken, request);
        Response<ModerationAPIResponse> response = responseCall.execute();
        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }
}
