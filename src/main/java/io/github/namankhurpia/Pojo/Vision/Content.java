package io.github.namankhurpia.Pojo.Vision;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Content {

    @SerializedName("type")
    @JsonProperty("type")
    public String type;

    @SerializedName("text")
    @JsonProperty("text")
    public String text;

    @SerializedName("image_url")
    @JsonProperty("image_url")
    public ImageUrl imageUrl;

    public Content(String type, String text, ImageUrl imageUrl) {
        this.type = type;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public Content() {
    }
}
