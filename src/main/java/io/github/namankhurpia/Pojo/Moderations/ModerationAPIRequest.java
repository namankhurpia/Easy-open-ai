package io.github.namankhurpia.Pojo.Moderations;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NonNull;

/**
 * This class is used to send request to OpenAI's moderation API
 */
@Data
public class ModerationAPIRequest {

    /**
     * This input is your prompt which needs to be tested against moderations API
     */
    @NonNull
    @SerializedName("input")
    public String input;

    /**
     * You can use two types of models as of now
     * 1. text-moderation-latest
     * 2. text-moderation-stable
     *
     */
    @SerializedName("model")
    public String model;

    public ModerationAPIRequest() {
    }
}
