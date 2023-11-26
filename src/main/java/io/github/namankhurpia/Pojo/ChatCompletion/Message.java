package io.github.namankhurpia.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {

    @JsonProperty("role")
    public String role;


    @JsonProperty("content")
    public String content;

    public Message() {
    }
}
