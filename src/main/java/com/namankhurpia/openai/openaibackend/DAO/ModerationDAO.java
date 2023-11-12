package com.namankhurpia.openai.openaibackend.DAO;

import com.namankhurpia.openai.openaibackend.Interfaces.EndPoints;
import com.namankhurpia.openai.openaibackend.Interfaces.apiInterface;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.*;

import java.io.IOException;

@Service
public class ModerationDAO implements EndPoints {


    apiInterface apiInterface;
    private static Logger LOGGER = LoggerFactory.getLogger(ModerationDAO.class);

    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {


        apiInterface = APIClient.getClient().create(com.namankhurpia.openai.openaibackend.Interfaces.apiInterface.class);
        LOGGER.debug("making req" + accessToken + " with request "+ request.toString());
        Call<ModerationAPIResponse> call = (Call<ModerationAPIResponse>) apiInterface.getmoderation(accessToken, request);
        call.enqueue(new Callback<ModerationAPIResponse>() {
            @Override
            public void onResponse(Call<ModerationAPIResponse> call, Response<ModerationAPIResponse> response) {

                System.out.println(response.body());

            }

            @Override
            public void onFailure(Call<ModerationAPIResponse> call, Throwable throwable) {

            }
        });

        return null;


    }
}
