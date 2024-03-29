package io.github.namankhurpia.Service;

import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Exception.MalformedRequestException;
import io.github.namankhurpia.Pojo.MyModels.EasyVisionRequest;
import io.github.namankhurpia.Pojo.Speech.EasyTranscriptionRequest;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.IOException;

public class EasyTranscriptionService {

    public ResponseBody EasyTranscription(String accessToken, EasyTranscriptionRequest request) throws IOException {

        if(request.getModel()==null || request.getModel().isEmpty())
        {
            throw new MalformedRequestException("Model name empty", new Throwable("Model name empty"));
        }
        else if(request.getFilepath()==null || request.getFilepath().isEmpty())
        {
            throw new MalformedRequestException("File path name empty", new Throwable("File path  name empty"));
        }


        RequestBody model,language,prompt,response_format,temperature;

         model = RequestBody.create(MediaType.parse("text/plain"), request.getModel());

        if(request.getLanguage()==null || request.getLanguage().isEmpty())
        {
             language = RequestBody.create(MediaType.parse("text/plain"), "");
        }
        else {
             language = RequestBody.create(MediaType.parse("text/plain"), request.getLanguage());
        }


        if(request.getPrompt()==null || request.getPrompt().isEmpty())
        {
             prompt = RequestBody.create(MediaType.parse("text/plain"), "");
        }
        else {
             prompt = RequestBody.create(MediaType.parse("text/plain"), request.getPrompt());
        }

        if(request.getResponseFormat()==null || request.getResponseFormat().isEmpty())
        {
             response_format = RequestBody.create(MediaType.parse("text/plain"), "");
        }
        else {
             response_format = RequestBody.create(MediaType.parse("text/plain"), request.getResponseFormat());
        }

        if(request.getTemperature()==null || request.getTemperature()==0)
        {
             temperature = RequestBody.create(MediaType.parse("text/plain"), "");
        }
        else {
             temperature = RequestBody.create(MediaType.parse("text/plain"), request.getTemperature().toString());
        }


        File audioFile = new File(request.getFilepath());
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                audioFile.getName(),
                RequestBody.create(MediaType.parse("audio/*"), audioFile)
        );

        ResponseBody response = new EasyopenaiService(new DAOImpl()).createTranscriptions(accessToken, filePart,model, language,prompt,response_format,temperature);
        return response;
    }

}
