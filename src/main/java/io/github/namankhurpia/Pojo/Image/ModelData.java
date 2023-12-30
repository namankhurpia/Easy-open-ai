package io.github.namankhurpia.Pojo.Image;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ModelData {

    @JsonProperty("revised_prompt")
    @SerializedName("revised_prompt")
    public String revisedPrompt;

    @JsonProperty("url")
    @SerializedName("url")
    public String url;

}
