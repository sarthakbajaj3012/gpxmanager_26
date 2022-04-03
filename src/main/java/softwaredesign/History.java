package softwaredesign;

import softwaredesign.sports.Sports;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Sports> list;

    public History(){
        this.list = new ArrayList<Sports>();
    }

    public void add (Sports data){
        list.add(data);
    }

    public List<Sports> data(){
        return this.list;
    }
}
