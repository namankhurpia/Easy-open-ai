package io.github.namankhurpia.Pojo.MyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EasyChatRequest {

    @SerializedName("model")
    @JsonProperty("model")
    String model;

    @SerializedName("prompt")
    @JsonProperty("prompt")
    ArrayList<String> prompt;

}
