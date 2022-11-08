package Behavioral;

import java.util.Date;

//        Step 1
//        Create mediator class.
 class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date() + " [" + user.getName() + "] : " + message);
    }
}


//        Step 2
//        Create user class
 class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}


//        Step 3
//        Use the User object to show communications between them.
 class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}


//        Step 4
//        Verify the output.
//
//        Thu Jan 31 16:05:46 IST 2013 [Robert] : Hi! John!
//        Thu Jan 31 16:05:46 IST 2013 [John] : Hello! Robert!