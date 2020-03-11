package Exceptions;

public class LengthException extends Exception {
    private int n;
    public int getN(){return n;}
    public LengthException(String message, int n) {
        super(message);
        n = n;
    }
}
