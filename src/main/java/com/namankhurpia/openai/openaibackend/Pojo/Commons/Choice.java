package com.namankhurpia.openai.openaibackend.Pojo.Commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.Message;
import lombok.Data;


/**
 * The reason the model stopped generating tokens.
 * This will be stop if the model hit a natural stop point or a provided stop sequence, length if the
 * maximum number of tokens specified in the request was reached, or content_filter if
 * content was omitted due to a flag from our content filters.
 */
@Data
public class Choice {


    @JsonProperty("text")
    public String text;

    @JsonProperty("index")
    public Integer index;

    @JsonProperty("logprobs")
    public Object logprobs;

    @JsonProperty("message")
    public Message message;

    @JsonProperty("finish_reason")
    public String finish_reason;


}
