import Exceptions.LengthException;
import Exceptions.NumException;
import Exceptions.OperatorException;

public class Tools {
    public static String[] SplitString(String string) throws LengthException, OperatorException, NumException {
        String[] s = string.split(" ");
        if (s.length == 3) {
            if (s[1].matches("[+\\-/*]")) {
                if (s[0].matches("\\d|\\d0") && s[2].matches("\\d|\\d0")) {
                    return s;
                } else if (s[0].matches("I{1,3}|I?VI{0,3}|I?X") && s[2].matches("I{1,3}|I?VI{0,3}|I?X")) {
                    return s;
                } else {
                    throw new NumException("Ошибка ввода чисел");
                }
            } else {
                throw new OperatorException("Неверный оператор", s[1]);
            }
        } else {
            throw new LengthException("Неверное количество параметров", s.length);
        }
    }

    public static Integer ConvertFromGrece(String string) {
        char[] chars =  string.toCharArray();
        int n = 0;
        boolean isPrevOne = false;
        for (char aChar : chars) {
            int curN = GreceNum.valueOf(Character.toString(aChar)).value;
            if (curN == 1)
                isPrevOne = true;
            if (isPrevOne && curN != 1) {
                n += GreceNum.valueOf(Character.toString(aChar)).value - 2;
            } else {
                n += GreceNum.valueOf(Character.toString(aChar)).value;
            }
        }
        return n;
    }
}
