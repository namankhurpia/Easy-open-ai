package io.github.namankhurpia.Pojo.Vision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class VisionApiRequest {

    @SerializedName("model")
    @JsonProperty("model")
    public String model;

    @SerializedName("messages")
    @JsonProperty("messages")
    public List<MessageList> messages;

    @SerializedName("max_tokens")
    @JsonProperty("max_tokens")
    public Integer maxTokens;


}
