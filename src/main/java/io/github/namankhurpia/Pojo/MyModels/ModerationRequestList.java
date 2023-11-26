package io.github.namankhurpia.Pojo.MyModels;

import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ModerationRequestList {

    //Min Size = 1;
    ArrayList<ModerationAPIRequest> requestList;

    ModerationRequestList()
    {

    }
}
