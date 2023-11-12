package com.namankhurpia.openai.openaibackend.Service;

import com.namankhurpia.openai.openaibackend.DAO.ModerationDAO;
import com.namankhurpia.openai.openaibackend.Interfaces.apiInterface;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;

@Component
public class ModerationAPIServiceImpl implements apiInterface {


    private final ModerationDAO dao;

    @Autowired
    public ModerationAPIServiceImpl(ModerationDAO dao) {
        this.dao = dao;
    }

    @Override
    public Call<ModerationAPIResponse> getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {
        dao.getmoderation(accessToken, request);
        return null;
    }

}
