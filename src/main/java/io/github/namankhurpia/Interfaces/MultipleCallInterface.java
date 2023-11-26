package io.github.namankhurpia.Interfaces;

import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;

public interface MultipleCallInterface {

    ModerationResponseList CallMultipleModerationAPI(ModerationRequestList requestList);

}
