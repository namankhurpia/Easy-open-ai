package io.github.namankhurpia.Service;


import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Interfaces.DaoInterface;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionRequest;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Speech.SpeechRequest;
import io.github.namankhurpia.Pojo.Speech.TranscriptionRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiResponse;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;


import java.io.IOException;


public class EasyopenaiService implements DaoInterface {

    private DAOImpl dao;

    public EasyopenaiService(DAOImpl dao) {
        this.dao = dao;
    }

    @Override
    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {
        return dao.getmoderation(accessToken, request);

    }

    @Override
    public CompletionResponse getCompletion(String accessToken, CompletionRequest request) throws IOException {
        return dao.getCompletion(accessToken,request);
    }

    @Override
    public ChatCompletionResponse chatCompletion(String accessToken, ChatCompletionRequest request) throws IOException {
        return dao.chatCompletion(accessToken,request);
    }

    @Override
    public VisionApiResponse visionAPI(String accessToken, VisionApiRequest request) throws IOException {
        return dao.visionAPI(accessToken,request);
    }

    @Override
    public ResponseBody createSpeech(String accessToken, SpeechRequest request) throws IOException {
        return dao.createSpeech(accessToken,request);
    }

    @Override
    public ResponseBody createTranscriptions(String accessToken, MultipartBody.Part file, TranscriptionRequest request) throws IOException {
        return dao.createTranscriptions(accessToken,file,request);
    }


}
