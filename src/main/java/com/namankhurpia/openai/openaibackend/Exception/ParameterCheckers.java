package com.namankhurpia.openai.openaibackend.Exception;

import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatMessage;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.Message;
import com.namankhurpia.openai.openaibackend.Pojo.Completion.CompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.Moderations.ModerationAPIRequest;
import org.springframework.util.StringUtils;

import java.util.List;

public class ParameterCheckers {

    //input and model are mandatory fields
    public static boolean checkParamForModeration(ModerationAPIRequest request)
    {
        return ( (StringUtils.isEmpty(request.getModel()) || request.getModel()==null) || (StringUtils.isEmpty(request.getInput()) || request.getInput()==null))?true:false;
    }


    //model and prompt are mandatory fields
    public static boolean checkParamForCompletion(CompletionRequest request)
    {
        return ( (StringUtils.isEmpty(request.getModel()) || request.getModel()==null) || (StringUtils.isEmpty(request.getPrompt()) || request.getPrompt()==null))?true:false;
    }

    //model , message (role and content) are mandatory fields
    public static boolean checkParamForChatCompletion_modelName(ChatCompletionRequest request)
    {
        return (StringUtils.isEmpty(request.getModel()) || request.getModel()==null)?true:false;
    }

    //model , message (role and content) are mandatory fields
    public static boolean checkParamForChatCompletion_Messages_role_content(ChatCompletionRequest request)
    {
        List<ChatMessage> messages = request.getMessages();
        if(messages.size()<=0)
        {
            return true;
        }
        for(int i=0;i<messages.size();i++)
        {
            if(StringUtils.isEmpty(messages.get(i).getRole())  ||  messages.get(i).getRole()==null || StringUtils.isEmpty(messages.get(i).getContent())  ||  messages.get(i).getContent()==null)
            {
                return true;
            }
        }
        return false;
    }
}
