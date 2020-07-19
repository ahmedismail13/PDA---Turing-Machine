package problem.pkg2;

import java.util.*;


public class Problem2 {

    public static void main(String[] args) {
        ArrayList<state> list = new ArrayList<>();
        list.add(new state("q0",false));
        list.add(new state("q1",false));
        list.add(new state("q2",false));
        list.add(new state("q3",false));
        list.add(new state("q4",false));
        list.add(new state("q5",false));
        list.add(new state("q6",false));
        list.add(new state("q7",false));
        list.add(new state("q8",true));
        list.add(new state("qDead",false));
        
        list.get(0).addTrans('ε','ε','$',1);
        list.get(1).addTrans('a','ε','a',2);
        list.get(2).addTrans('a','ε','a',2);
        list.get(2).addTrans('c','ε','ε',3);
        list.get(2).addTrans('d','ε','ε',4);
        list.get(3).addTrans('b','a','ε',7);
        list.get(4).addTrans('b','a','ε',5);
        list.get(5).addTrans('b','ε','ε',6);
        list.get(6).addTrans('b','a','ε',5);
        list.get(6).addTrans('ε','$','ε',8);
        list.get(7).addTrans('b','a','ε',7);
        list.get(7).addTrans('ε','$','ε',8);
        list.get(9).addTrans('a','ε','ε',9);
        list.get(9).addTrans('b','ε','ε',9);
        list.get(9).addTrans('c','ε','ε',9);
        list.get(9).addTrans('d','ε','ε',9);
        list.get(9).addTrans('ε','ε','ε',9);
        list.get(9).addTrans('$','ε','ε',9);
        
        while(true)
        {
            Stack<Character> stack = new Stack<>();
            stack.push(list.get(0).getTransitions().get(0).getPush());
            Scanner reader = new Scanner(System.in);
            String input = reader.next();
            int currentState =1;
            for(int i =0; i < input.length();i++)
            {
                ArrayList<Trans> test = new ArrayList<>();
                test = list.get(currentState).getTransitions();
                char testInput = input.charAt(i);
                int decision=-1;
                for(int j =0; j < test.size();j++)
                {
                    if(testInput == test.get(j).getInput())
                        decision =j;
                }
                if(decision != -1)
                {
                    if(list.get(currentState).getTransitions().get(decision).getPush() == 'ε')
                    {
                        if( list.get(currentState).getTransitions().get(decision).getPop() == 'ε')
                        {
                            currentState = list.get(currentState).getTransitions().get(decision).getDest();
                        }
                        else
                        {
                            if(stack.size()==1)
                            {
                                currentState =-1;
                                break;
                            }
                            else
                            {
                                stack.pop();
                                currentState = list.get(currentState).getTransitions().get(decision).getDest();
                            }
                        }

                    }
                    else
                    {
                        if(list.get(currentState).getTransitions().get(decision).getPop() == 'ε')
                        {
                            stack.push(list.get(currentState).getTransitions().get(decision).getPush());
                            currentState = list.get(currentState).getTransitions().get(decision).getDest();
                        }
                        else
                        {
                            stack.pop();
                            stack.push(list.get(currentState).getTransitions().get(decision).getPush());
                            currentState = list.get(currentState).getTransitions().get(decision).getDest();
                        }

                    }

                }
                else
                {
                    currentState = 9;
                }

            }
            if((stack.lastElement() == '$' && currentState == 6 && stack.size() ==1)||(stack.lastElement()=='$' && currentState == 7 && stack.size()==1))
            {
                stack.pop();
                currentState =8;
            }
            if(stack.isEmpty()&&currentState == 8)
                System.out.println("ACCEPTS");
            else
                System.out.println("REJECTS");
        }
    }
    
}
