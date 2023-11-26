
package io.github.namankhurpia.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;


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
