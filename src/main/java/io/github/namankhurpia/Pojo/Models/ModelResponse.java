package io.github.namankhurpia.Pojo.Models;

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
public class ModelResponse {

    @SerializedName("object")
    @JsonProperty("object")
    public String object;

    @SerializedName("data")
    @JsonProperty("data")
    public List<ModelField> data;


}
