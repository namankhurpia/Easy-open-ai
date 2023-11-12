package com.namankhurpia.openai.openaibackend.Service;

import com.namankhurpia.openai.openaibackend.DAO.ModerationDAO;
import com.namankhurpia.openai.openaibackend.Interfaces.apiInterface;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ModerationAPIServiceImpl implements apiInterface {


    @Autowired
    ModerationDAO dao;

    @Override
    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {
        return dao.getmoderation(accessToken,request);
    }
}
