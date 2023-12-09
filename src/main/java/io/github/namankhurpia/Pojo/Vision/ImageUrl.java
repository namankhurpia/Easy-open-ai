package io.github.namankhurpia.Pojo.Vision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ImageUrl {

    @SerializedName("url")
    @JsonProperty("url")
    public String url;

    @SerializedName("detail")
    @JsonProperty("detail")
    public String detail;

}
