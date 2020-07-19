package problem1;

import java.util.*;


public class state {
    String name;
    ArrayList<Trans> transitions = new ArrayList<>();
    boolean accepted;

    public state(String name, boolean accepted) {
        this.name = name;
        this.accepted = accepted;
    }
    
    public void addTrans(char read, char write, char direction, int dest)
    {
        Trans t = new Trans(read,write,direction,dest);
        transitions.add(t);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Trans> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<Trans> transitions) {
        this.transitions = transitions;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    
}
