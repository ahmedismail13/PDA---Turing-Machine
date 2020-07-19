package problem.pkg2;

import java.util.*;

public class state {
    String name;
    ArrayList<Trans> transitions = new ArrayList<>();
    boolean accepted;

    public state(String name, boolean accepted) {
        this.name = name;
        this.accepted = accepted;
    }
    
    public void addTrans(char input, char pop, char push, int dest)
    {
        Trans t = new Trans(input,pop,push,dest);
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
