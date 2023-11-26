package io.github.namankhurpia;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Service.AsyncModerationAPIServiceImpl;
import io.github.namankhurpia.Service.ModerationAPIServiceImpl;

import java.io.IOException;
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


        AsyncModerationAPIServiceImpl obj2 = new AsyncModerationAPIServiceImpl(new AsyncDAOImpl());
        ModerationAPIResponse res =  obj2.getASyncmoderation(OPENAI_KEY,request);
        System.out.println(res);

    }
}