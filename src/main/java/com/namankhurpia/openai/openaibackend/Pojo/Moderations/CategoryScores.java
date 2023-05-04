
package com.namankhurpia.openai.openaibackend.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sexual",
    "hate",
    "violence",
    "self-harm",
    "sexual/minors",
    "hate/threatening",
    "violence/graphic"
})
@Data
public class CategoryScores {

    @JsonProperty("sexual")
    public Float sexual;
    @JsonProperty("hate")
    public Float hate;
    @JsonProperty("violence")
    public Float violence;
    @JsonProperty("self-harm")
    public Float selfHarm;
    @JsonProperty("sexual/minors")
    public Float sexualMinors;
    @JsonProperty("hate/threatening")
    public Float hateThreatening;
    @JsonProperty("violence/graphic")
    public Float violenceGraphic;

}
