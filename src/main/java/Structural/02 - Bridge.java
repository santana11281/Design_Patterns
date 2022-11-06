package Structural;

//        Step 1
//        Create bridge implementer interface.


interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}
//        Step 2
//        Create concrete bridge implementer classes implementing the DrawAPI interface.


class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}


class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

//        Step 3
//        Create an abstract class Shape using the DrawAPI interface.


    abstract class Shape {
        protected DrawAPI drawAPI;

        protected Shape(DrawAPI drawAPI) {
            this.drawAPI = drawAPI;
        }

        public abstract void draw();
    }
//        Step 4
//        Create concrete class implementing the Shape interface.

class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
//        Step 5
//        Use the Shape and DrawAPI classes to draw different colored circles.


class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
//        Step 6
//        Verify the output.
//        Drawing Circle[ color: red, radius: 10, x: 100, 100]
//        Drawing Circle[  color: green, radius: 10, x: 100, 100]