import Exceptions.LengthException;
import Exceptions.NumException;
import Exceptions.OperatorException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine();
            StringMath sm = null;
            try {
                sm = new StringMath(string);
            } catch (LengthException | NumException | OperatorException e) {
                e.printStackTrace();
                System.exit(0);
            }
            System.out.println(sm.Result());
        }
    }
}
