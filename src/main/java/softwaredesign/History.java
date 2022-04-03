package softwaredesign;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Sports> list;

    public History(){
        this.list = new ArrayList<>();
    }

    public void add (Sports data){
        list.add(data);
    }

    public Sports find(Integer id){
        return this.list.get(id -1);
    }
}
