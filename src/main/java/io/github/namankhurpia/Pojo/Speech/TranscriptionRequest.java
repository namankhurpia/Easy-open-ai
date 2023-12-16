package io.github.namankhurpia.Pojo.Speech;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.MultipartBody;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TranscriptionRequest {

    String model;

    String language;

    String prompt;

    @JsonProperty("response_format")
    String responseFormat;

    Integer temperature;



}
