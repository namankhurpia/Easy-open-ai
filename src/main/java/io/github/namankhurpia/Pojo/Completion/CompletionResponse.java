package io.github.namankhurpia.Pojo.Completion;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.namankhurpia.Pojo.Commons.Choice;
import io.github.namankhurpia.Pojo.Commons.Usage;
import lombok.Data;

import java.util.List;

@Data
public class CompletionResponse {

    /**
     * id
     * string
     * A unique identifier for the completion.
     */
    @JsonProperty("id")
    public String id;

    /**
     * string
     * The object type, which is always "text_completion"
     */
    @JsonProperty("object")
    public String object;

    /**
     * The Unix timestamp (in seconds) of when the completion was created.
     */
    @JsonProperty("created")
    public Integer created;

    /**
     * The model used for completion.
     */
    @JsonProperty("model")
    public String model;

    /**
     * choices
     * array
     * The list of completion choices the model generated for the input prompt.
     */
    @JsonProperty("choices")
    public List<Choice> choices;



    @JsonProperty("usage")
    public Usage usage;

    @JsonProperty("system_fingerprint")
    public Usage systemFingerprint;

    public CompletionResponse( ) {

    }

}
