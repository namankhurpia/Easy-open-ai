
package io.github.namankhurpia.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
public class CategoryScores {

    @SerializedName("sexual")
    public Double sexual;

    @SerializedName("hate")
    public Double hate;

    @SerializedName("harassment")
    public Double harassment;

    @SerializedName("self-harm")
    public Double selfHarm;

    @SerializedName("sexual/minors")
    public Double sexualMinors;

    @SerializedName("hate/threatening")
    public Double hateThreatening;

    @SerializedName("violence/graphic")
    public Double violenceGraphic;

    @SerializedName("self-harm/intent")
    public Double selfHarmIntent;

    @SerializedName("self-harm/instructions")
    public Double selfHarmInstructions;

    @SerializedName("harassment/threatening")
    public Double harassmentThreatening;

    @SerializedName("violence")
    public Double violence;



}
