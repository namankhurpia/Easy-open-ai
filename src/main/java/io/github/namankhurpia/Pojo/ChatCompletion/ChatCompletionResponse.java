package io.github.namankhurpia.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.namankhurpia.Pojo.Commons.Choice;
import io.github.namankhurpia.Pojo.Commons.Usage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatCompletionResponse {

    @JsonProperty("id")
    public String id;

    @JsonProperty("object")
    public String object;

    @JsonProperty("created")
    public Integer created;

    @JsonProperty("model")
    public String model;

    @JsonProperty("system_fingerprint")
    public String system_fingerprint;

    @JsonProperty("choices")
    public List<Choice> choices;

    @JsonProperty("usage")
    public Usage usage;


}
