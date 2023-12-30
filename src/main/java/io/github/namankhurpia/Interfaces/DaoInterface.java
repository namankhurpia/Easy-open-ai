package io.github.namankhurpia.Interfaces;

import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionRequest;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Image.ImageRequest;
import io.github.namankhurpia.Pojo.Image.ImageResponse;
import io.github.namankhurpia.Pojo.Models.ModelResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Speech.SpeechRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;

import java.io.IOException;

public interface DaoInterface {

    //input and model are mandatory fields
    ModerationAPIResponse getmoderation(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException;

    //model and prompt are mandatory fields
    CompletionResponse getCompletion(@Header("Authorization")String accessToken, @Body CompletionRequest request) throws IOException;

    //model , message (role and content) are mandatory fields
    ChatCompletionResponse chatCompletion(@Header("Authorization") String accessToken, @Body ChatCompletionRequest request) throws  IOException;

    VisionApiResponse visionAPI(@Header("Authorization")String accessToken, @Body VisionApiRequest request)throws  IOException;

    ResponseBody createSpeech(@Header("Authorization")String accessToken, @Body SpeechRequest request) throws IOException;

    ResponseBody createTranscriptions(@Header("Authorization")String accessToken, @Part MultipartBody.Part file, @Part RequestBody model, @Part RequestBody language, @Part RequestBody prompt, @Part RequestBody response_format, @Part RequestBody temperature ) throws IOException;

    ImageResponse createImage(@Header("Authorization")String accessToken, ImageRequest imageRequest) throws IOException;

    ModelResponse getAllModels(@Header("Authorization")String accessToken)throws IOException;

}
