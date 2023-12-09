package io.github.namankhurpia.Service;

import io.github.namankhurpia.DAO.AsyncDAOImpl;
import io.github.namankhurpia.Interfaces.AsyncApiInterface;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Vision.VisionApiRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class EasyopenaiAsyncService implements AsyncApiInterface {

    private AsyncDAOImpl asyncdao;

    public EasyopenaiAsyncService(AsyncDAOImpl asyncdao) {
        this.asyncdao = asyncdao;
    }

    @Override
    public ModerationAPIResponse getASyncModeration(String accessToken, ModerationAPIRequest request) throws IOException, ExecutionException, InterruptedException {
        return asyncdao.getASyncModeration(accessToken,request);

    }

    @Override
    public ChatCompletionResponse getAsyncChatCompletion(String accessToken, ChatCompletionRequest request) throws IOException, ExecutionException, InterruptedException {
       return asyncdao.getAsyncChatCompletion(accessToken,request);
    }

    @Override
    public VisionApiResponse getAsyncVisionAPI(String accessToken, VisionApiRequest request) throws IOException, ExecutionException, InterruptedException {
        return asyncdao.getAsyncVisionAPI(accessToken,request);
    }
}
