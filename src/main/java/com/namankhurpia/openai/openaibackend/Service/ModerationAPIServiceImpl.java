package com.namankhurpia.openai.openaibackend.Service;

import com.namankhurpia.openai.openaibackend.DAO.DAOImpl;
import com.namankhurpia.openai.openaibackend.Interfaces.DaoInterface;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ModerationAPIServiceImpl implements DaoInterface {

    private final DAOImpl dao;

    @Autowired
    public ModerationAPIServiceImpl(DAOImpl dao) {
        this.dao = dao;
    }

    @Override
    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {
        return dao.getmoderation(accessToken, request);

    }

    @Override
    public CompletionResponse getCompletion(String accessToken, CompletionRequest request) throws IOException {
        return dao.getCompletion(accessToken,request);
    }

    @Override
    public ChatCompletionResponse chatCompletion(String accessToken, ChatCompletionRequest request) throws IOException {
        return dao.chatCompletion(accessToken,request);
    }

}
