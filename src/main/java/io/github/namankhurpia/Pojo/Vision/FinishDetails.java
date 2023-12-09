package io.github.namankhurpia.Pojo.Vision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class FinishDetails {

    @SerializedName("type")
    @JsonProperty("type")
    public String type;

    @SerializedName("stop")
    @JsonProperty("stop")
    public String stop;


}
