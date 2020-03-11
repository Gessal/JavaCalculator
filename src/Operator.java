public enum Operator {
    PLUS {
        public int result(int x, int y){ return x + y;}
        },
    MINUS {
        public int result(int x, int y){ return x - y;}
        },
    MULTIPLY {
        public int result(int x, int y){ return x * y;}
        },
    DIVISION {
        public int result(int x, int y){ return x / y;}
        };
    public abstract int result(int x, int y);
}
