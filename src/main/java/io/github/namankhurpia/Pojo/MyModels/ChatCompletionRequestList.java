package io.github.namankhurpia.Pojo.MyModels;

import io.github.namankhurpia.Pojo.ChatCompletion.ChatCompletionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Collection;

/**
 * contains all functionality of an arraylist
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatCompletionRequestList {

    /**
     *  Min Size = 1;
     */

    ArrayList<ChatCompletionRequest> requestList;


    public void add(ChatCompletionRequest obj)
    {
        requestList.add(obj);
    }

    public void remove(int index)
    {
        requestList.remove(index);
    }

    public void remove(ChatCompletionRequest obj)
    {
        requestList.remove(obj);
    }

    public int size()
    {
        return requestList.size();
    }

    public void add(int index, ChatCompletionRequest element)
    {
        requestList.add(index, element);
    }

    public void addAll(Collection collection)
    {
        requestList.addAll(collection);
    }

    public void addAll(int index,Collection collection)
    {
        requestList.addAll(index,collection);
    }

    public void clear()
    {
        requestList.clear();
    }

    public boolean contains(ChatCompletionRequest request)
    {
        return requestList.contains(request);
    }

    public ChatCompletionRequest get(int index)
    {
        return requestList.get(index);
    }

    public int indexOf(ChatCompletionRequest obj)
    {
        return requestList.indexOf(obj);
    }

    public boolean isEmpty()
    {
        return requestList.isEmpty();
    }



}
