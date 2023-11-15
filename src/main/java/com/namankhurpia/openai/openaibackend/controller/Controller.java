package com.namankhurpia.openai.openaibackend.controller;

import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionResponse;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import com.namankhurpia.openai.openaibackend.Service.ModerationAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    ModerationAPIServiceImpl moderationService;

    @PostMapping("/moderation")
    public ModerationAPIResponse getModeration(@RequestHeader("Authorization") String accessToken, @RequestBody ModerationAPIRequest request) throws IOException {
        return moderationService.getmoderation(accessToken, request);
    }

    @PostMapping("/completion")
    public CompletionResponse getCompletion(@RequestHeader("Authorization") String accessToken, @RequestBody CompletionRequest request) throws IOException {
        return moderationService.getCompletion(accessToken, request);
    }

    @PostMapping("/chat")
    public ChatCompletionResponse chatCompletion(@RequestHeader("Authorization") String accessToken, @RequestBody ChatCompletionRequest request) throws IOException {
        return moderationService.chatCompletion(accessToken, request);
    }



}
