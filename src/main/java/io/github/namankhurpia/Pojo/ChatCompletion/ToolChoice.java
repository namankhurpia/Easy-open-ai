package io.github.namankhurpia.Pojo.ChatCompletion;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToolChoice {

    @JsonProperty("type")
    String type;

    Function function;
}
