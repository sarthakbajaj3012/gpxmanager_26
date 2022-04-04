package softwaredesign;

import softwaredesign.sports.Sports;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Sports> list;
    private static History history = null;

    private History(){
        this.list = new ArrayList<Sports>();
    }

    public void add (Sports data){
        list.add(data);
    }

    public static History getInstance(){
        if(history == null)
            history = new History();

        return history;
    }


    public String getHistory() {
        String s="";
        for(int i = 0; i< list.size();i++){
            s +="\n" + list.get(i).getData();
        }
        return s;
    }
}
