package com.namankhurpia.openai.openaibackend.Exception;

import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatCompletionRequest;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.ChatMessage;
import com.namankhurpia.openai.openaibackend.Pojo.ChatCompletion.Message;
import org.springframework.util.StringUtils;

import java.util.List;

public class ParameterCheckers {

    public static boolean checkParamForChatCompletion_modelName(ChatCompletionRequest request)
    {
        return true;
    }

    public static boolean checkParamForChatCompletion_Messages_role_content(ChatCompletionRequest request)
    {
        List<ChatMessage> messages = request.getMessages();
        if(messages.size()<=0)
        {
            return false;
        }
        for(int i=0;i<messages.size();i++)
        {
            if(StringUtils.isEmpty(messages.get(i).getRole())  ||  messages.get(i).getRole()==null || StringUtils.isEmpty(messages.get(i).getContent())  ||  messages.get(i).getContent()==null)
            {
                return false;
            }
        }
        return true;
    }
}
