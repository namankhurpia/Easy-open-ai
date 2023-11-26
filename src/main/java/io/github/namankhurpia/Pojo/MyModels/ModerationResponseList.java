package io.github.namankhurpia.Pojo.MyModels;

import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ModerationResponseList {

    ArrayList<ModerationAPIResponse> responseList;

    ModerationResponseList()
    {

    }

}
