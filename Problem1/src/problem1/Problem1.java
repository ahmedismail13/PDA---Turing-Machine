package problem1;
import java.util.*;

public class Problem1 {

    
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
        list.add(new state("q8",false));
        list.add(new state("q9",true));
        
        list.get(0).addTrans('1','x','R',1);
        
        list.get(1).addTrans('1','1','R',1);
        list.get(1).addTrans('x','x','R',1);
        list.get(1).addTrans('y','y','R',1);
        list.get(1).addTrans('j','j','R',1);
        list.get(1).addTrans('k','k','R',1);
        list.get(1).addTrans('l','l','R',1);
        list.get(1).addTrans('m','m','R',1);
        list.get(1).addTrans('n','n','R',1);
        list.get(1).addTrans('⊔','y','R',2);
        
        list.get(2).addTrans('⊔','j','R',3);
        list.get(3).addTrans('⊔','k','R',4);
        list.get(4).addTrans('⊔','l','R',5);
        list.get(5).addTrans('⊔','m','R',6);
        list.get(6).addTrans('⊔','n','L',7);
        
        list.get(7).addTrans('⊔','⊔','R',8);
        list.get(7).addTrans('1','x','R',1);
        list.get(7).addTrans('x','x','L',7);
        list.get(7).addTrans('y','y','L',7);
        list.get(7).addTrans('j','j','L',7);
        list.get(7).addTrans('k','k','L',7);
        list.get(7).addTrans('l','l','L',7);
        list.get(7).addTrans('m','m','L',7);
        list.get(7).addTrans('n','n','L',7);
        
        list.get(8).addTrans('⊔','1','R',9);
        list.get(8).addTrans('x','1','R',8);
        list.get(8).addTrans('y','1','R',8);
        list.get(8).addTrans('j','1','R',8);
        list.get(8).addTrans('k','1','R',8);
        list.get(8).addTrans('l','1','R',8);
        list.get(8).addTrans('m','1','R',8);
        list.get(8).addTrans('n','1','R',8);
        
        while(true)
        {
            ArrayList<Character> tape = new ArrayList<>();
            for(int i=0;i<10000;i++)
                tape.add('⊔');
            int tapeHead = 1;
            Scanner reader = new Scanner(System.in);
            int inp = reader.nextInt();
            String input = "";
            for(int i =0;i<inp;i++)
                input += "1";
            int currentState =1;
            for(int i=1;i<=input.length();i++)
            {
                tape.set(i, input.charAt(i-1));
            }
            while(true){
                ArrayList<Trans> test = new ArrayList<>();
                test = list.get(currentState).getTransitions();
                char testInput = tape.get(tapeHead);
                int decision=-1;
                for(int j =0; j < test.size();j++)
                {
                    if(testInput == test.get(j).getRead()){
                        decision =j;
                        break;
                    }
                }
                if(decision != -1){
                    tape.set(tapeHead, list.get(currentState).getTransitions().get(decision).getWrite());
                    if(list.get(currentState).getTransitions().get(decision).getDirection() == 'L')
                        tapeHead--;
                    else if(list.get(currentState).getTransitions().get(decision).getDirection() == 'R')
                        tapeHead++;
                    currentState = list.get(currentState).getTransitions().get(decision).getDest();
                }
                else{
                    break;
                }
            }
            if(currentState == 9)
                System.out.println("ACCEPTS\n"+tape.toString());
            else
                System.out.println("REJECTS\n"+tape.toString());
        }
    }
    
}
