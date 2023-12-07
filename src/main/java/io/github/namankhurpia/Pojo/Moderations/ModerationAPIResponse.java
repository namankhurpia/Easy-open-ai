
package io.github.namankhurpia.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;



@Data
public class ModerationAPIResponse {

    @JsonProperty("id")
    public String id;

    @JsonProperty("model")
    public String model;

    @SerializedName("results")
    @JsonProperty("results")
    public List<Result> results;

}
