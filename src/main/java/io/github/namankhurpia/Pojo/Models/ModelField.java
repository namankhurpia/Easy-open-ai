package io.github.namankhurpia.Pojo.Models;

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
public class ModelField {

    @SerializedName("object")
    @JsonProperty("object")
    public String object;

    @SerializedName("id")
    @JsonProperty("id")
    public String id;

    @SerializedName("ready")
    @JsonProperty("ready")
    public Boolean ready;

    @SerializedName("owner")
    @JsonProperty("owner")
    public String owner;

    @SerializedName("permissions")
    @JsonProperty("permissions")
    public Object permissions;

    @SerializedName("created")
    @JsonProperty("created")
    public Object created;
    
    
}
