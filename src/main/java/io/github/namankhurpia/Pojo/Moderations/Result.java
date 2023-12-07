
package io.github.namankhurpia.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;



@Data
public class Result {

    @JsonProperty("flagged")
    public Boolean flagged;

    @JsonProperty("categories")
    public Categories categories;

    @SerializedName("category_scores")
    @JsonProperty("category_scores")
    public CategoryScores categoryScores;

}
