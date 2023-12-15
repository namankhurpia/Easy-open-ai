package io.github.namankhurpia.Pojo.MyModels;

import io.github.namankhurpia.Pojo.Moderations.ModerationAPIRequest;
import io.github.namankhurpia.Pojo.Moderations.ModerationAPIResponse;
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
public class ModerationResponseList {

    /**
     *  Min Size = 1;
     */
    ArrayList<ModerationAPIResponse> responseList;

    public void add(ModerationAPIResponse obj)
    {
        responseList.add(obj);
    }

    public void remove(int index)
    {
        responseList.remove(index);
    }

    public void remove(ModerationAPIResponse obj)
    {
        responseList.remove(obj);
    }

    public int size()
    {
        return responseList.size();
    }

    public void add(int index, ModerationAPIResponse element)
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

    public boolean contains(ModerationAPIResponse request)
    {
        return responseList.contains(request);
    }

    public ModerationAPIResponse get(int index)
    {
        return responseList.get(index);
    }

    public int indexOf(ModerationAPIResponse obj)
    {
        return responseList.indexOf(obj);
    }

    public boolean isEmpty()
    {
        return responseList.isEmpty();
    }


}
