package io.github.namankhurpia;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.MyModels.ModerationRequestList;
import io.github.namankhurpia.Pojo.MyModels.ModerationResponseList;
import io.github.namankhurpia.Service.AsyncModerationAPIServiceImpl;
import io.github.namankhurpia.Service.ModerationAPIServiceImpl;
import io.github.namankhurpia.Service.MultipleCalls.ConcurrentCalls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.github.namankhurpia.Interfaces.EndPoints.OPENAI_KEY;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        System.out.println("Hello world!");


        ModerationAPIServiceImpl obj = new ModerationAPIServiceImpl(new DAOImpl());

        //   ModerationAPIResponse res =  obj.getmoderation(key,request);

        ModerationAPIRequest request = new ModerationAPIRequest();
        request.setInput("kill me now");
        request.setModel("text-moderation-latest");

        ModerationAPIRequest request2 = new ModerationAPIRequest();
        request2.setInput("hurray me now");
        request2.setModel("text-moderation-latest");

        ModerationAPIRequest request3 = new ModerationAPIRequest();
        request3.setInput("SEX me now");
        request3.setModel("text-moderation-latest");

        ModerationAPIRequest request4 = new ModerationAPIRequest();
        request4.setInput("KILL me now");
        request4.setModel("text-moderation-latest");

        ModerationRequestList requestList = new ModerationRequestList(new ArrayList<ModerationAPIRequest>());
        requestList.add(request);
        requestList.add(request2);
        requestList.add(request3);
        requestList.add(request4);

        AsyncModerationAPIServiceImpl obj2 = new AsyncModerationAPIServiceImpl(new AsyncDAOImpl());

        //ModerationAPIResponse res =  obj2.getASyncmoderation(OPENAI_KEY,request);

        ConcurrentCalls concurrentCalls = new ConcurrentCalls();
        concurrentCalls.CallMultipleModerationAPI(OPENAI_KEY,requestList);



    }
}