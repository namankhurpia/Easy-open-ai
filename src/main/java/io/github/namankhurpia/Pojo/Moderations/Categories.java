
package io.github.namankhurpia.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


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
public class Categories {

    @JsonProperty("sexual")
    public Boolean sexual;
    @JsonProperty("hate")
    public Boolean hate;
    @JsonProperty("violence")
    public Boolean violence;
    @JsonProperty("self-harm")
    public Boolean selfHarm;
    @JsonProperty("sexual/minors")
    public Boolean sexualMinors;
    @JsonProperty("hate/threatening")
    public Boolean hateThreatening;
    @JsonProperty("violence/graphic")
    public Boolean violenceGraphic;

}
