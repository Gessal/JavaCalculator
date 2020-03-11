package Exceptions;

public class OperatorException extends Exception {
    private String s;
    public String getS(){return s;}
    public OperatorException(String message, String s) {
        super(message);
        s = s;
    }
}
