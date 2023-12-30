package io.github.namankhurpia.Interfaces;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import io.github.namankhurpia.Pojo.Completion.CompletionRequest;
import io.github.namankhurpia.Pojo.Completion.CompletionResponse;
import io.github.namankhurpia.Pojo.Image.ImageRequest;
import io.github.namankhurpia.Pojo.Image.ImageResponse;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
import io.github.namankhurpia.Pojo.Speech.SpeechRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiRequest;
import io.github.namankhurpia.Pojo.Vision.VisionApiResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.IOException;


public interface RetrofitApiInterface {

    //Moderation API to classify the input text
    @POST("/v1/moderations")
    Call<ModerationAPIResponse> getModeration(@Header("Authorization")String accessToken, @Body ModerationAPIRequest request) throws IOException;


    //Newer models (2023–) gpt-4 (and gpt-4 turbo), gpt-3.5-turbo
    @POST("/v1/completions")
    Call<CompletionResponse> getCompletion(@Header("Authorization")String accessToken, @Body CompletionRequest request)throws IOException;

    //Updated base models (2023) babbage-002, davinci-002 and Legacy models (2020–2022) text-davinci-003, text-davinci-002, davinci, curie, babbage, ada
    @POST("/v1/completions")
    Call<CompletionResponse> completion_old(@Header("Authorization")String accessToken, @Body CompletionRequest request)throws IOException;


    @POST("/v1/chat/completions")
    Call<ChatCompletionResponse> chatCompletion(@Header("Authorization") String accessToken, @Body ChatCompletionRequest request) throws  IOException;


    //gpt-4-vision-preview
    @POST("/v1/chat/completions")
    Call<VisionApiResponse> visionAPI(@Header("Authorization") String accessToken, @Body VisionApiRequest request) throws IOException;

    @POST("/v1/audio/speech")
    Call<ResponseBody> createSpeech(@Header("Authorization")String accessToken, @Body SpeechRequest request) throws IOException;

    @POST("/v1/audio/transcriptions")
    @Multipart
    Call<ResponseBody> createTranscriptions(@Header("Authorization")String accessToken,
                                            @Part MultipartBody.Part file,
                                            @Part("model") RequestBody model,
                                            @Part("language") RequestBody language,
                                            @Part("prompt") RequestBody prompt,
                                            @Part("response_format") RequestBody response_format,
                                            @Part("temperature")RequestBody temperature ) throws IOException;

    @POST("/v1/images/generations")
    Call<ImageResponse> createImage(@Header("Authorization")String accessToken, @Body ImageRequest imageRequest) throws IOException;

    @POST(".v1/images/edits")
    @Multipart
    Call<ResponseBody> createImageEdit(@Header("Authorization")String accessToken, @Part MultipartBody.Part image, @Part("prompt") RequestBody prompt );

}
