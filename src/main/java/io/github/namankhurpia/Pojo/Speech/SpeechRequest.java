package io.github.namankhurpia.Pojo.Speech;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpeechRequest {

    @NonNull
    String model;

    @NonNull
    String input;

    @NonNull
    String voice;

    @JsonProperty("response_format")
    String response_format;

    Double speed;

}
