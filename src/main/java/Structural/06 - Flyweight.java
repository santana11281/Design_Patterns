package Structural;
import java.util.HashMap;

//        Step 1
//        Create an interface.
interface FlyShape {
    void draw();
}


//        Step 2
//        Create concrete class implementing the same interface.
 class FlyCircle implements FlyShape {

    private final String color;
    private int x, y , radius;


    public FlyCircle(String color){
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}


//        Step 3
//        Create a factory to generate object of concrete class based on given information.
 class ShapeFactory {

    // Uncomment the compiler directive line and
    // javac *.java will compile properly.
    // @SuppressWarnings("unchecked")
    private static final HashMap circleMap = new HashMap();

    public static FlyShape getCircle(String color) {
        FlyCircle circle = (FlyCircle)circleMap.get(color);

        if(circle == null) {
            circle = new FlyCircle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}


//        Step 4
//        Use the factory to get object of concrete class by passing an information such as color.
 class FlyweightPatternDemo {


    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {

        for(int i=0; i < 20; ++i) {
            FlyCircle circle = (FlyCircle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}


//        Step 5
//        Verify the output.
//
//        Creating circle of color : Black
//        Circle: Draw() [Color : Black, x : 36, y :71, radius :100
//        Creating circle of color : Green
//        Circle: Draw() [Color : Green, x : 27, y :27, radius :100
//        Creating circle of color : White
//        Circle: Draw() [Color : White, x : 64, y :10, radius :100
//        Creating circle of color : Red
//        Circle: Draw() [Color : Red, x : 15, y :44, radius :100
//        Circle: Draw() [Color : Green, x : 19, y :10, radius :100
//        Circle: Draw() [Color : Green, x : 94, y :32, radius :100
//        Circle: Draw() [Color : White, x : 69, y :98, radius :100
//        Creating circle of color : Blue
//        Circle: Draw() [Color : Blue, x : 13, y :4, radius :100
//        Circle: Draw() [Color : Green, x : 21, y :21, radius :100
//        Circle: Draw() [Color : Blue, x : 55, y :86, radius :100
//        Circle: Draw() [Color : White, x : 90, y :70, radius :100
//        Circle: Draw() [Color : Green, x : 78, y :3, radius :100
//        Circle: Draw() [Color : Green, x : 64, y :89, radius :100
//        Circle: Draw() [Color : Blue, x : 3, y :91, radius :100
//        Circle: Draw() [Color : Blue, x : 62, y :82, radius :100
//        Circle: Draw() [Color : Green, x : 97, y :61, radius :100
//        Circle: Draw() [Color : Green, x : 86, y :12, radius :100
//        Circle: Draw() [Color : Green, x : 38, y :93, radius :100
//        Circle: Draw() [Color : Red, x : 76, y :82, radius :100
//        Circle: Draw() [Color : Blue, x : 95, y :82, radius :100