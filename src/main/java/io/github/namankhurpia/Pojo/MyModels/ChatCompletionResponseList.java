package io.github.namankhurpia.Pojo.MyModels;


import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionResponse;
import lombok.Data;
import retrofit2.http.Body;


import java.util.ArrayList;
import java.util.Collection;

/**
 * contains all functionality of an arraylist
 */
@Data
public class ChatCompletionResponseList {

    /**
     *  Min Size = 1;
     */
    ArrayList<ChatCompletionResponse> responseList;

    public ChatCompletionResponseList(ArrayList<ChatCompletionResponse> requestList)
    {
        this.responseList = requestList;
    }

    public void add(ChatCompletionResponse obj)
    {
        responseList.add(obj);
    }

    public void remove(int index)
    {
        responseList.remove(index);
    }

    public void remove(ChatCompletionResponse obj)
    {
        responseList.remove(obj);
    }

    public int size()
    {
        return responseList.size();
    }

    public void add(int index, ChatCompletionResponse element)
    {
        responseList.add(index, element);
    }

    public void addAll(Collection collection)
    {
        responseList.addAll(collection);
    }

    public void addAll(int index,Collection collection)
    {
        responseList.addAll(index,collection);
    }

    public void clear()
    {
        responseList.clear();
    }

    public boolean contains(ChatCompletionResponse request)
    {
        return responseList.contains(request);
    }

    public ChatCompletionResponse get(int index)
    {
        return responseList.get(index);
    }

    public int indexOf(ChatCompletionResponse obj)
    {
        return responseList.indexOf(obj);
    }

    public boolean isEmpty()
    {
        return responseList.isEmpty();
    }

}
