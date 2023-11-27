package io.github.namankhurpia.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Function {

    /**
     * name
     * string
     * The name of the function to call.
     */
    @JsonProperty("name")
    String name;

    /**
     * arguments
     * string
     * The arguments to call the function with, as generated by the model in JSON format. Note that the model does not always generate valid JSON, and may hallucinate parameters not defined by your function schema. Validate the arguments in your code before calling your function.
     */
    @JsonProperty("arguments")
    String arguments;

    public Function() {
    }
}