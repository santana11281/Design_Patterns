package Behavioral;

//        Step 1
//        Create an interface.
 interface Strategy {
    public int doOperation(int num1, int num2);
}


//        Step 2
//        Create concrete classes implementing the same interface.
 class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}


 class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}


 class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}


//        Step 3
//        Create Context Class.
 class SContext {
    private Strategy strategy;

    public SContext(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}


//        Step 4
//        Use the Context to see change in behaviour when it changes its Strategy.
 class StrategyPatternDemo {
    public static void main(String[] args) {
        SContext context = new SContext(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new SContext(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new SContext(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}


//        Step 5
//        Verify the output.
//        10 + 5 = 15
//        10 - 5 = 5
//        10 * 5 = 50