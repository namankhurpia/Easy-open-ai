package io.github.namankhurpia.Interfaces;

import io.github.namankhurpia.Pojo.MyModels.ChatCompletionRequestList;
import io.github.namankhurpia.Pojo.MyModels.ChatCompletionResponseList;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;

public interface ConcurrentApiInterface {

    ModerationResponseList CallMultipleModerationAPI(String key,ModerationRequestList requestList);

    ChatCompletionResponseList CallMultipleChatCompletionAPI(String key, ChatCompletionRequestList requestList);

}
