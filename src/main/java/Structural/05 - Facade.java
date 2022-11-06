package Structural;

//        Step 1
//        Create an interface.
 interface FShape {
    void draw();
}

//        Step 2
//        Create concrete classes implementing the same interface.
 class FRectangle implements FShape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}


 class FSquare implements FShape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}


 class FCircle implements FShape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}


//        Step 3
//        Create a facade class.
 class ShapeMaker {
    private FShape circle;
    private FShape rectangle;
    private FShape square;

    public ShapeMaker() {
        circle = new FCircle();
        rectangle = new FRectangle();
        square = new FSquare();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}


//        Step 4
//        Use the facade to draw various types of shapes.
 class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}


//        Step 5
//        Verify the output.
//        Circle::draw()
//        Rectangle::draw()
//        Square::draw()