package io.github.namankhurpia.Pojo.Commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.github.namankhurpia.Pojo.ChatCompletion.SystemMessage;
import io.github.namankhurpia.Pojo.Vision.FinishDetails;
import lombok.Data;


/**
 * The reason the model stopped generating tokens.
 * This will be stop if the model hit a natural stop point or a provided stop sequence, length if the
 * maximum number of tokens specified in the request was reached, or content_filter if
 * content was omitted due to a flag from our content filters.
 */
@Data
public class Choice {

    @SerializedName("text")
    @JsonProperty("text")
    public String text;

    @SerializedName("index")
    @JsonProperty("index")
    public Integer index;

    @SerializedName("logprobs")
    @JsonProperty("logprobs")
    public Object logprobs;

    @SerializedName("message")
    @JsonProperty("message")
    public SystemMessage systemMessage;

    @SerializedName("finish_reason")
    @JsonProperty("finish_reason")
    public String finish_reason;

    @SerializedName("finish_details")
    @JsonProperty("finish_details")
    public FinishDetails finishDetails;


}
