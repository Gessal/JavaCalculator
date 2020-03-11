import Exceptions.LengthException;
import Exceptions.NumException;
import Exceptions.OperatorException;

public class StringMath {
    private Integer[] nums = new Integer[2];
    private Operator operator;
    private boolean isGreece;

    public StringMath(String string) throws LengthException, NumException, OperatorException {
        String[] strings = Tools.SplitString(string);
        switch (strings[1]) {
            case ("+"):
                operator = Operator.PLUS;
                break;
            case ("-"):
                operator = Operator.MINUS;
                break;
            case ("*"):
                operator = Operator.MULTIPLY;
                break;
            case ("/"):
                operator = Operator.DIVISION;
                break;
        }
        if (strings[0].matches("\\d+")) {
            nums[0] = Integer.valueOf(strings[0]);
            nums[1] = Integer.valueOf(strings[2]);
            isGreece = false;
        }
        else {
            nums[0] = Tools.ConvertFromGrece(strings[0]);
            nums[1] = Tools.ConvertFromGrece(strings[2]);
            isGreece = true;
        }
    }

    public String Result() {
        int result = operator.result(nums[0], nums[1]);
        if (isGreece) {
            StringBuilder sb = new StringBuilder();
            for (int i = GreceNum.values().length - 1; i >= 0; i--) {
                GreceNum currGN = GreceNum.values()[i];
                if (result != 0 && result + 1 == currGN.value) {
                    sb.append("I").append(currGN.toString());
                    return sb.toString();
                }
                for (int j = 0; j < (int) result / currGN.value; i++) {
                    sb.append(currGN.toString());
                    result -= currGN.value;
                }
            }
            return sb.toString();
        }
        else {
            return String.valueOf(result);
        }
    }
}
