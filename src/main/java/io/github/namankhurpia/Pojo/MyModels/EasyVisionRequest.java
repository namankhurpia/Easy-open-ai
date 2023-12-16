package io.github.namankhurpia.Pojo.MyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EasyVisionRequest {

    @SerializedName("model")
    @JsonProperty("model")
    String model;

    @SerializedName("imageUrls")
    @JsonProperty("imageUrls")
    ArrayList<String> imageUrls;

    @SerializedName("prompt")
    @JsonProperty("prompt")
    String prompt;

    /**
     * optional - defaults to 300
     */
    @SerializedName("maxtokens")
    @JsonProperty("maxtokens")
    Integer maxtokens;

    public String getModel() {
        return model;
    }

    public EasyVisionRequest setModel(String model) {
        this.model = model;
        return this;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public EasyVisionRequest setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
        return this;
    }

    public String getPrompt() {
        return prompt;
    }

    public EasyVisionRequest setPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    public Integer getMaxtokens() {
        return maxtokens;
    }

    public EasyVisionRequest setMaxtokens(Integer maxtokens) {
        this.maxtokens = maxtokens;
        return this;
    }
}
