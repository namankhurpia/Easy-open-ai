package com.namankhurpia.openai.openaibackend.Pojo.Completion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * usage
 * object
 * Usage statistics for the completion request.
 */
public class Usage {

    @JsonProperty("prompt_tokens")
    public Integer promptTokens;

    @JsonProperty("completion_tokens")
    public Integer completionTokens;

    @JsonProperty("total_tokens")
    public Integer totalTokens;
}
