
package com.namankhurpia.openai.openaibackend.Pojo.Moderations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@JsonPropertyOrder({
    "flagged",
    "categories",
    "category_scores"
})
@Data
public class Result {

    @JsonProperty("flagged")
    public Boolean flagged;
    @JsonProperty("categories")
    public Categories categories;
    @JsonProperty("category_scores")
    public CategoryScores categoryScores;

}
