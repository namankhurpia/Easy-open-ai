package com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.namankhurpia.openai.openaibackend.Pojo.Commons.Choice;
import com.namankhurpia.openai.openaibackend.Pojo.Commons.Usage;

import java.util.List;

public class ChatCompletionResponse {

    @JsonProperty("id")
    public String id;

    @JsonProperty("object")
    public String object;

    @JsonProperty("created")
    public Integer created;

    @JsonProperty("model")
    public String model;

    @JsonProperty("system_fingerprint")
    public String system_fingerprint;

    @JsonProperty("choices")
    public List<Choice> choices;

    @JsonProperty("usage")
    public Usage usage;


}
