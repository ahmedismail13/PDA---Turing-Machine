package problem.pkg2;


public class Trans {
    char input;
    char pop;
    char push;
    int dest;

    public Trans(char input, char pop, char push, int dest) {
        this.input = input;
        this.pop = pop;
        this.push = push;
        this.dest = dest;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public char getInput() {
        return input;
    }

    public void setInput(char input) {
        this.input = input;
    }

    public char getPop() {
        return pop;
    }

    public void setPop(char pop) {
        this.pop = pop;
    }

    public char getPush() {
        return push;
    }

    public void setPush(char push) {
        this.push = push;
    }
    
}
