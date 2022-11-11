package Creational;


//        Step 1
//        Create an interface.
interface Shape {
    void draw();
}

//        Step 2
//        Create concrete classes implementing the same interface.
class FRectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}


class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}


class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}


//        Step 3
//        Create a Factory to generate object of concrete class based on given information.
class FShapeFactory extends AbstractFactory {

    //use getShape method to get object of type shape
    public Shape getShape(String shapeType) {

        if (shapeType == null)
            return null;
        else
            return switch (shapeType) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new FRectangle();
            case "SQUARE" -> new Square();
            default -> null;
        };

    }
}


//        Step 4
//        Use the Factory to get object of concrete class by passing an information such as type.
class FactoryPatternDemo {

    public static void main(String[] args) {
        FShapeFactory shapeFactory = new FShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }
}


//        Step 5
//        Verify the output.
//
//        Inside Circle::draw() method.
//        Inside Rectangle::draw() method.
//        Inside Square::draw() method.