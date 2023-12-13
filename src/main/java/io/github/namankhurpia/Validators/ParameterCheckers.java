package io.github.namankhurpia.Validators;

import io.github.namankhurpia.Pojo.ChatCompletion.Message;
import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import io.github.namankhurpia.Pojo.Completion.CompletionRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import org.apache.commons.lang3.StringUtils;


import java.util.List;

/**
 * This class contains static methods to check any obvious inconsistencies in request. (Mandatory field checks)
 */
public class ParameterCheckers {

    /**
     *  input and model are mandatory fields
     */

    public static boolean checkParamForModeration(ModerationAPIRequest request)
    {
        return ( (StringUtils.isEmpty(request.getModel()) || request.getModel()==null) || (StringUtils.isEmpty(request.getInput()) || request.getInput()==null))?true:false;
    }


    /**
     * model and prompt are mandatory fields
     */
    public static boolean checkParamForCompletion(CompletionRequest request)
    {
        return ( (StringUtils.isEmpty(request.getModel()) || request.getModel()==null) || (StringUtils.isEmpty(request.getPrompt()) || request.getPrompt()==null))?true:false;
    }

    /**
     * model , message (role and content) are mandatory fields
     */
    public static boolean checkParamForChatCompletion_modelName(ChatCompletionRequest request)
    {
        return (StringUtils.isEmpty(request.getModel()) || request.getModel()==null)?true:false;
    }

    /**
     * model , message (role and content) are mandatory fields
     */
    public static boolean checkParamForChatCompletion_Messages_role_content(ChatCompletionRequest request)
    {
        List<Message> messages = request.getMessages();
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

    /**
     * checking if key is non null - further invalid checks and balance will be returned by openai's API
     */
    public static boolean isInValidOpenAIKey(String key)
    {
        return (StringUtils.isEmpty(key) || key==null)?true:false;
    }

}
