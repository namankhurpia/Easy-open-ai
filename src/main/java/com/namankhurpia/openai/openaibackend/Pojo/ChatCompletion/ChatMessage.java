package com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class ChatMessage {

    @NonNull
    String role;

    @NonNull
    @JsonInclude() // content should always exist in the call, even if it is null
    String content;
    //name is optional, The name of the author of this message. May contain a-z, A-Z, 0-9, and underscores, with a maximum length of 64 characters.
    String name;

    @JsonProperty("tool_calls")
    List<ToolCalls> tool_calls;

    @JsonProperty("function_call")
    ChatFunctionCall function_call;

    public ChatMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public ChatMessage(String role, String content, String name) {
        this.role = role;
        this.content = content;
        this.name = name;
    }

    public ChatMessage() {

    }
}
