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


    public void getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {

        //Retrofit retrofit = APIClient.getClient();
        //apiInterface = retrofit.create(apiInterface.class);
        apiInterface = APIClient.getClient().create(com.namankhurpia.openai.openaibackend.Interfaces.apiInterface.class);
        LOGGER.debug("making req" + accessToken + " with request "+ request.toString());
        Call<ModerationAPIResponse> call = (Call<ModerationAPIResponse>) apiInterface.getmoderation(accessToken, request);
        Response<ModerationAPIResponse> response = call.execute();

        if (response.isSuccessful()) {
            LOGGER.debug(response.body().toString());
        } else {
            // Handle unsuccessful response (e.g., log, throw exception, etc.)
            LOGGER.error("Moderation API request failed with code: {}", response.code());

        }


    }
}
