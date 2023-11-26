package io.github.namankhurpia.Service;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Interfaces.AsyncApiInterface;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncModerationAPIServiceImpl implements AsyncApiInterface {

    private AsyncDAOImpl asyncdao;

    public AsyncModerationAPIServiceImpl(AsyncDAOImpl asyncdao) {
        this.asyncdao = asyncdao;
    }

    @Override
    public ModerationAPIResponse getASyncmoderation(String accessToken, ModerationAPIRequest request) throws IOException, ExecutionException, InterruptedException {
        return asyncdao.getASyncmoderation(accessToken,request);

    }
}
