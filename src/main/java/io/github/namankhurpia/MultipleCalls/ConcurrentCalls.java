package io.github.namankhurpia.MultipleCalls;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.Exception.InvalidSizeException;
import io.github.namankhurpia.Interfaces.MultipleCallInterface;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;
import io.github.namankhurpia.Service.AsyncModerationAPIServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class ConcurrentCalls implements MultipleCallInterface {

    ModerationResponseList responseList;

    @Override
    public ModerationResponseList CallMultipleModerationAPI(ModerationRequestList requestList) {

        int n = requestList.getRequestList().size();
        if(n<=0)
        {
            throw new InvalidSizeException("Moderation Request List must have atleast 1 instance",new Throwable());
        }

        List<CompletableFuture<ModerationAPIResponse>> futures = new ArrayList<>();
        AsyncModerationAPIServiceImpl AsyncObj = new AsyncModerationAPIServiceImpl(new AsyncDAOImpl());

        for(int i=0;i<n;i++)
        {
            CompletableFuture<ModerationAPIResponse> resultFuture = CompletableFuture.supplyAsync(() ->{
                return  AsyncObj.getASyncmoderation(OPENAI_KEY,requestList.getRequestList().get(i));

            });
            futures.add(resultFuture);
        }



        return null;

    }
}
