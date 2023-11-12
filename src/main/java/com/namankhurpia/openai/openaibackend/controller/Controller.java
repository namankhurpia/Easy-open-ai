package com.namankhurpia.openai.openaibackend.controller;

import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIResponse;
import com.namankhurpia.openai.openaibackend.DAO.ModerationDAO;
import com.namankhurpia.openai.openaibackend.Service.ModerationAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.namankhurpia.openai.openaibackend.Interfaces.EndPoints.openai_key;

@RestController
public class Controller {

    @Autowired
    ModerationAPIServiceImpl moderationService;

    @PostMapping("/mod")
    public ModerationAPIResponse getModeration(@RequestParam String accessToken, @RequestBody ModerationAPIRequest request) throws IOException {
        return moderationService.getmoderation(openai_key, request);
    }

    @GetMapping("/hello")
    public String getHello()
    {
        return "hey";
    }



}
