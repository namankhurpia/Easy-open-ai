package io.github.namankhurpia.DAO;

import io.github.namankhurpia.Exception.MalformedRequestException;
import io.github.namankhurpia.Interfaces.DaoInterface;
import io.github.namankhurpia.Interfaces.RetrofitApiInterface;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.*;

import java.io.IOException;

import static io.github.namankhurpia.Validators.ParameterCheckers.*;


public class DAOImpl implements DaoInterface {




    ModerationAPIResponse moderationAPIResponseObj;
    CompletionResponse completionResponseObj;

    ChatCompletionResponse chatCompletionResponseObj;

    VisionApiResponse visionApiResponseObj;

    ResponseBody responseBodyObj;

    ImageResponse imageResponse;

    ModelResponse modelResponse;

    private static Logger LOGGER = LoggerFactory.getLogger(DAOImpl.class);

    RetrofitApiInterface retrofitApiInterfaceObj;



    @Override
    public ModerationAPIResponse getmoderation(String accessToken, ModerationAPIRequest request) throws IOException {


        // Param checking
        if (checkParamForModeration(request)) {
            throw new MalformedRequestException("Request object has Model name empty or Input empty ", new Throwable());
        }

        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("Making request " + accessToken + " with request " + request.toString());


        Call<ModerationAPIResponse> call = retrofitApiInterfaceObj.getModeration("Bearer "+accessToken, request);

        try {
            Response<ModerationAPIResponse> response = call.execute();

            if (response.isSuccessful()) {
                moderationAPIResponseObj = response.body();
                System.out.println(moderationAPIResponseObj.toString());
            } else {
                int httpStatusCode = response.code();
                String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
                String errorBodyString = response.errorBody().string();
                System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);

                throw new MalformedRequestException(errorBody, new Throwable(errorBody));

            }
        } catch (IOException e) {
            // Handle IO exception
            System.out.println("IOException: " + e.getMessage());
            throw e;
        }

        return moderationAPIResponseObj;
    }

    @Override
        public CompletionResponse getCompletion(String accessToken, CompletionRequest request) throws IOException {
            //param checking
            if(checkParamForCompletion(request))
            {
                throw new MalformedRequestException("Request object has Model name empty or promp empty ", new Throwable());
            }

            retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);

            LOGGER.info("making req" + accessToken + " with request "+ request.toString());
            Call<CompletionResponse> call = retrofitApiInterfaceObj.getCompletion("Bearer "+accessToken,request);
            Response<CompletionResponse> response = call.execute();

            if(response.isSuccessful())
            {
                completionResponseObj = response.body();
                LOGGER.info("Correct response" + completionResponseObj.toString());
            }
            else
            {
                int httpStatusCode = response.code();
                String errorBody = response.errorBody() != null ? response.errorBody().string() : "Empty error body";
                String errorBodyString = response.errorBody().string();
                System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);
                throw new MalformedRequestException(errorBody, new Throwable(errorBody));
            }

            return  completionResponseObj;
        }



        @Override
        public ChatCompletionResponse chatCompletion(String accessToken, ChatCompletionRequest request) throws IOException {
            //param checking
            if(checkParamForChatCompletion_Messages_role_content(request))
            {
                throw new MalformedRequestException("messages Object has either role or content Empty", new Throwable());
            }
            if(checkParamForChatCompletion_modelName(request))
            {
                throw new MalformedRequestException("Request object has Model name empty, please specify a model you wish to use", new Throwable());
            }

            retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);

            LOGGER.info("making req" + accessToken + " with request "+ request.toString());
            Call<ChatCompletionResponse> call = retrofitApiInterfaceObj.chatCompletion("Bearer "+accessToken,request);
            Response<ChatCompletionResponse> response = call.execute();

            if(response.isSuccessful())
            {
                chatCompletionResponseObj = response.body();
                LOGGER.info("Correct response" + chatCompletionResponseObj.toString());
            }
            else
            {
                int httpStatusCode = response.code();
                String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
                String errorBodyString = response.errorBody().string();
                System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);
                throw new MalformedRequestException(errorBody, new Throwable(errorBody));

            }




            return  chatCompletionResponseObj;
        }

    @Override
    public VisionApiResponse visionAPI(String accessToken, VisionApiRequest request) throws IOException {

        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("making req" + accessToken + " with request "+ request.toString());

        Call<VisionApiResponse> call =  retrofitApiInterfaceObj.visionAPI("Bearer "+accessToken,request);
        Response<VisionApiResponse> response = call.execute();

        if(response.isSuccessful())
        {
            visionApiResponseObj = response.body();
            LOGGER.info("Correct response" + visionApiResponseObj.toString());
        }
        else {
            int httpStatusCode = response.code();

            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            String errorBodyString = response.errorBody().string();
            System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);
            throw new MalformedRequestException(errorBody, new Throwable(errorBody));

        }

        return visionApiResponseObj;
    }

    @Override
    public ResponseBody createSpeech(String accessToken, SpeechRequest request) throws IOException{

        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("making req" + accessToken + " with request "+ request.toString());

        Call<ResponseBody> call =  retrofitApiInterfaceObj.createSpeech("Bearer "+accessToken, request);
        Response<ResponseBody> response = call.execute();

        if(response.isSuccessful())
        {
            responseBodyObj= response.body();
            LOGGER.info("Correct response" + responseBodyObj.toString());
        }
        else {
            int httpStatusCode = response.code();

            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            String errorBodyString = response.errorBody().string();
            System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);
            throw new MalformedRequestException(errorBody, new Throwable(errorBody));

        }

        return responseBodyObj;

    }

    @Override
    public ResponseBody createTranscriptions(String accessToken, MultipartBody.Part file, RequestBody model, RequestBody language, RequestBody prompt, RequestBody response_format, RequestBody temperature) throws IOException {
        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("making req" + accessToken + " with request ");

        Call<ResponseBody> call =  retrofitApiInterfaceObj.createTranscriptions("Bearer "+accessToken,file ,model, language, prompt, response_format, temperature);
        Response<ResponseBody> response = call.execute();

        if(response.isSuccessful())
        {
            responseBodyObj= response.body();
            LOGGER.info("Correct response" + responseBodyObj.toString());
        }
        else {
            int httpStatusCode = response.code();

            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            String errorBodyString = response.errorBody().string();
            System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);

            throw new MalformedRequestException(errorBody, new Throwable(errorBody));


        }

        return responseBodyObj;
    }

    @Override
    public ImageResponse createImage(String accessToken, ImageRequest imageRequest) throws IOException {
        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("making req" + accessToken + " with request "+ imageRequest);

        Call<ImageResponse> call =  retrofitApiInterfaceObj.createImage("Bearer "+ accessToken, imageRequest);
        Response<ImageResponse> response = call.execute();

        if(response.isSuccessful())
        {
            imageResponse= response.body();
            LOGGER.info("Correct response" + imageResponse.toString());
        }
        else {
            int httpStatusCode = response.code();

            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            String errorBodyString = response.errorBody().string();
            System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);

            throw new MalformedRequestException(errorBody, new Throwable(errorBody));


        }

        return imageResponse;
    }

    @Override
    public ModelResponse getAllModels(String accessToken) throws IOException {
        retrofitApiInterfaceObj = RetrofitAPIClient.getClient().create(RetrofitApiInterface.class);
        LOGGER.info("making req" + accessToken );

        Call<ModelResponse> call =  retrofitApiInterfaceObj.getAllModels("Bearer "+ accessToken);
        Response<ModelResponse> response = call.execute();

        if(response.isSuccessful())
        {
            modelResponse= response.body();
            LOGGER.info("Correct response" + modelResponse.toString());
        }
        else {
            int httpStatusCode = response.code();

            String errorBody = response.errorBody() != null ? String.valueOf(response.errorBody()) : "Empty error body";
            String errorBodyString = response.errorBody().string();
            System.out.println("Unsuccessful response with HTTP status code " + httpStatusCode + " and error body: " + errorBodyString);

            throw new MalformedRequestException(errorBody, new Throwable(errorBody));


        }

        return modelResponse;
    }


}
