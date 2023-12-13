package io.github.namankhurpia.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * This class can be used to encapsulate System Messages and User Message and Function Message (deprecated)
 */
@Data
public class SystemMessage {

    @NonNull
    @JsonProperty("role")
    public String role;


    @NonNull
    @JsonProperty("content")
    public String content;

    @JsonProperty("name")
    public String name;


    public SystemMessage() {
    }
}
