package problem1;


public class Trans {
    char write;
    char read;
    char direction;
    int dest;

    public Trans(char read, char write, char direction, int dest) {
        this.write = write;
        this.read = read;
        this.direction = direction;
        this.dest = dest;
    }

    public char getWrite() {
        return write;
    }

    public void setWrite(char write) {
        this.write = write;
    }

    public char getRead() {
        return read;
    }

    public void setRead(char read) {
        this.read = read;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
    
    
}
