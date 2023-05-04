
package com.namankhurpia.openai.openaibackend.Pojo.Moderations;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.Result;
import lombok.Data;


@JsonPropertyOrder({
    "id",
    "model",
    "results"
})
@Data
public class ModerationAPIResponse {

    @JsonProperty("id")
    public String id;
    @JsonProperty("model")
    public String model;
    @JsonProperty("results")
    public List<Result> results;

}
