
package io.github.namankhurpia.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;




@Data
public class Categories {
    
    
    @SerializedName("harassment")
    public Boolean harassment;
    @SerializedName("self-harm")
    public Boolean selfHarm;
    @SerializedName("sexual/minors")
    public Boolean sexualMinors;
    @SerializedName("hate/threatening")
    public Boolean hateThreatening;
    @SerializedName("violence/graphic")
    public Boolean violenceGraphic;
    @SerializedName("self-harm/intent")
    public Boolean selfHarmIntent;
    @SerializedName("self-harm/instructions")
    public Boolean selfHarmInstructions;
    @SerializedName("harassment/threatening")
    public Boolean harassmentThreatening;
    @SerializedName("violence")
    public Boolean violence;

}
