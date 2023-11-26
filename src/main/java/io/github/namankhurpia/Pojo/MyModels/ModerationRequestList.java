package io.github.namankhurpia.Pojo.MyModels;

import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * contains all functionality of an arraylist
 */
@Data
public class ModerationRequestList {

    /**
     *  Min Size = 1;
     */

    ArrayList<ModerationAPIRequest> requestList;

    public ModerationRequestList(ArrayList<ModerationAPIRequest> requestList)
    {
        this.requestList = requestList;
    }

    public void add(ModerationAPIRequest obj)
    {
        requestList.add(obj);
    }

    public void remove(int index)
    {
        requestList.remove(index);
    }

    public void remove(ModerationAPIRequest obj)
    {
        requestList.remove(obj);
    }

    public int size()
    {
       return requestList.size();
    }

    public void add(int index, ModerationAPIRequest element)
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

    public boolean contains(ModerationAPIRequest request)
    {
        return requestList.contains(request);
    }

    public ModerationAPIRequest get(int index)
    {
        return requestList.get(index);
    }

    public int indexOf(ModerationAPIRequest obj)
    {
        return requestList.indexOf(obj);
    }

    public boolean isEmpty()
    {
        return requestList.isEmpty();
    }








}
