package com.namankhurpia.openai.openaibackend.Pojo.Commons;

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
    public Integer prompt_tokens;

    @JsonProperty("completion_tokens")
    public Integer completion_tokens;

    @JsonProperty("total_tokens")
    public Integer total_tokens;
}
