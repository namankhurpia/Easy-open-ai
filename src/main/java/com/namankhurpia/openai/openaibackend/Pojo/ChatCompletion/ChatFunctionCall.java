package com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class ChatFunctionCall {

    /**
     * The name of the function being called
     */
    @JsonProperty("name")
    String name;

    /**
     * The arguments of the call produced by the model, represented as a JsonNode for easy manipulation.
     */

    @JsonProperty("arguments")
    JsonNode arguments;
}
