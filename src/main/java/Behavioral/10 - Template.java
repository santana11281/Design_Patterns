package Behavioral;

//        Step 1
//        Create an abstract class with a template method being final.
 abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //template method
    public final void play(){

        //initialize the game
        initialize();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}


//        Step 2
//        Create concrete classes extending the above class.
 class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}


 class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}


//        Step 3
//        Use the Game's template method play() to demonstrate a defined way of playing game.
 class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}


//        Step 4
//        Verify the output.
//
//        Cricket Game Initialized! Start playing.
//        Cricket Game Started. Enjoy the game!
//        Cricket Game Finished!
//
//        Football Game Initialized! Start playing.
//        Football Game Started. Enjoy the game!
//        Football Game Finished!