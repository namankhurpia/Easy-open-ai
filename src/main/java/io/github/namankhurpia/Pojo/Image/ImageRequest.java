package io.github.namankhurpia.Pojo.Image;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ImageRequest {

    /**
     * This input is your prompt which needs to be tested against moderations API
     */
    @NonNull
    @JsonProperty("prompt")
    @SerializedName("prompt")
    public String prompt;

    /**
     * Defaults to dall-e-2
     * dall-e-3
     *
     */
    @JsonProperty("model")
    @SerializedName("model")
    public String model;

    @JsonProperty("n")
    @SerializedName("n")
    Integer n;

    @JsonProperty("quality")
    @SerializedName("quality")
    String quality;

    @JsonProperty("response_format")
    @SerializedName("response_format")
    String response_format;

    @JsonProperty("size")
    @SerializedName("size")
    String size;

    @JsonProperty("style")
    @SerializedName("style")
    String style;

    @JsonProperty("user")
    @SerializedName("user")
    String user;

}
