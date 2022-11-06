package Structural;//Step 1
//        Create an interface.


 interface IShape {
    void draw();
}
//Step 2
//        Create concrete classes implementing the same interface.


 class Rectangle implements IShape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}


 class DCircle implements IShape {

     @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

//        Step 3
//        Create abstract decorator class implementing the Shape interface.


 abstract class ShapeDecorator implements IShape {
    protected IShape decoratedShape;

    public ShapeDecorator(IShape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
//        Step 4
//        Create concrete decorator class extending the ShapeDecorator class.


 class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(IShape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(IShape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
//        Step 5
//        Use the RedShapeDecorator to decorate Shape objects.


 class DecoratorPatternDemo {
    public static void main(String[] args) {

        var circle = new DCircle();

        var redCircle = new RedShapeDecorator(new DCircle());

        var redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
//Step 6
//        Verify the output.
//
//        Circle with normal border
//        Shape: Circle
//
//        Circle of red border
//        Shape: Circle
//        Border Color: Red
//
//        Rectangle of red border
//        Shape: Rectangle
//        Border Color: Red