package io.github.namankhurpia.Pojo.Vision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.github.namankhurpia.Pojo.Commons.Choice;
import io.github.namankhurpia.Pojo.Commons.Usage;
import lombok.Data;

import java.util.List;

@Data
public class VisionApiResponse {

    @SerializedName("id")
    @JsonProperty("id")
    public String id;

    @SerializedName("object")
    @JsonProperty("object")
    public String object;

    @SerializedName("created")
    @JsonProperty("created")
    public Integer created;

    @SerializedName("model")
    @JsonProperty("model")
    public String model;

    @SerializedName("usage")
    @JsonProperty("usage")
    public Usage usage;

    @SerializedName("choices")
    @JsonProperty("choices")
    public List<Choice> choices;

}
