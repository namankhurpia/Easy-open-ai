package io.github.namankhurpia.Pojo.Vision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class MessageList {

    @SerializedName("role")
    @JsonProperty("role")
    public String role;

    @SerializedName("content")
    @JsonProperty("content")
    public List<Content> content;

}
