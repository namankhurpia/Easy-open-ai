package io.github.namankhurpia.Pojo.Image;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ImageResponse {

    @JsonProperty("created")
    @SerializedName("created")
    public Integer created;

    @JsonProperty("data")
    @SerializedName("data")
    public List<ModelData> data;


}
