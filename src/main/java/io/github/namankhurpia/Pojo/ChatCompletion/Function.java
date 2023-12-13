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

    @JsonProperty("description")
    String description;


    /**
     * The parameters the functions accepts, described as a JSON Schema object. See the guide for examples, and the JSON Schema reference for documentation about the format.
     *
     * To describe a function that accepts no parameters, provide the value {"type": "object", "properties": {}}
     */
    @JsonProperty("parameters")
    String parameters;




    public Function() {
    }
}
