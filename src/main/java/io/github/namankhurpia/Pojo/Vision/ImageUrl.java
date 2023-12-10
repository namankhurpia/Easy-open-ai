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

    public ImageUrl(String url, String detail) {
        this.url = url;
        this.detail = detail;
    }

    public ImageUrl() {
    }
}
