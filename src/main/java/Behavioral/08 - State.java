package Behavioral;

//        Step 1
//        Create an interface.
 interface State {
    void doAction(Context context);
}


//        Step 2
//        Create concrete classes implementing the same interface.
 class StartState implements State {

    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}


 class StopState implements State {

    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}


//        Step 3
//        Create Context Class.
 class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}


//        Step 4
//        Use the Context to see change in behaviour when State changes.
 class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState());
    }
}


//        Step 5
//        Verify the output.
//        Player is in start state
//        Start State
//        Player is in stop state
//        Stop State