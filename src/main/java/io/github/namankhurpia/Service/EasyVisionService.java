package io.github.namankhurpia.Service;

import io.github.namankhurpia.DAO.DAOImpl;
import io.github.namankhurpia.Pojo.MyModels.EasyVisionRequest;
import io.github.namankhurpia.Pojo.Vision.*;

import java.io.IOException;
import java.util.ArrayList;

public class EasyVisionService {

    public VisionApiResponse VisionAPI(String accessToken, EasyVisionRequest request) throws IOException {

        VisionApiRequest originalVisionRequest = new VisionApiRequest();
        ArrayList<Content> listofContent = new ArrayList<>();

        Content content_prompt = new Content();
        content_prompt.setText(request.getPrompt());
        content_prompt.setType("text");
        listofContent.add(content_prompt);

        Content temp;
        int n = request.getImageUrls().size();
        for(int i=0;i<n;i++)
        {
            temp = new Content("image_url",null, new ImageUrl(request.getImageUrls().get(i),"high"));
            listofContent.add(temp);
        }

        System.out.println(listofContent);

        MessageList messageList = new MessageList();
        messageList.setRole("user");
        messageList.setContent(listofContent);

        ArrayList<MessageList> listofMessage= new ArrayList<>();
        listofMessage.add(messageList);

        originalVisionRequest.setModel(request.getModel());
        originalVisionRequest.setMessages(listofMessage);

        if(request.getMaxtokens()==null ||request.getMaxtokens()==0 )
        {
            originalVisionRequest.setMaxTokens(300);
        }

        EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
        VisionApiResponse res = obj.visionAPI(accessToken,originalVisionRequest);

        return  res;


    }

}
