package io.github.namankhurpia.Interfaces;

import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionRequestList;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionResponseList;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;

import java.util.ArrayList;

public interface ConcurrentApiInterface {

    ModerationResponseList CallMultipleModerationAPI(String key,ModerationRequestList requestList);

    ChatCompletionResponseList CallMultipleChatCompletionAPI(String key, ChatCompletionRequestList requestList);

    ChatCompletionResponseList CallMultipleChatCompletionAPI(ArrayList<String> keyList, ChatCompletionRequestList requestList);
}
