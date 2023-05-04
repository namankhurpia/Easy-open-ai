package com.namankhurpia.openai.openaibackend;

import com.namankhurpia.openai.openaibackend.Service.ModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    ModerationService moderationService;




}
