package io.github.namankhurpia.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToolCalls {

    /**
     * id
     * string
     * The ID of the tool call.
     */
    @JsonProperty("id")
    String id;

    /**
     * type
     * string
     * The type of the tool. Currently, only function is supported.
     */
    @JsonProperty("type")
    String type;

    @JsonProperty("function")
    Function function;


}
