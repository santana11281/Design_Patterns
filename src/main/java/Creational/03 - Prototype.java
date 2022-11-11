package Creational;

import java.util.Hashtable;
import java.util.LinkedList;


//        Step 1
//        Create an abstract class implementing Clonable interface.
 abstract class PShape implements Cloneable {

    private String id;
    protected String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    abstract void draw();



    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}


//        Step 2
//        Create concrete classes extending the above class.
 class PRectangle extends PShape {

    public PRectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}


 class PSquare extends PShape {

    public PSquare(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}


 class PCircle extends PShape {

    public PCircle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}


//        Step 3
//        Create a class to get concrete classes from database and store them in a Hashtable.
 class ShapeCache {

    private static final Hashtable<String, PShape> shapeMap  = new Hashtable<>();

    public static PShape getShape(String shapeId) {
        PShape cachedShape = shapeMap.get(shapeId);
        return (PShape) cachedShape.clone();
    }

    // for each shape run database query and create shape
    // shapeMap.put(shapeKey, shape);
    // for example, we are adding three shapes

    public static void loadCache() {
        PCircle circle = new PCircle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        PSquare square = new PSquare();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        PRectangle rectangle = new PRectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}


//        Step 4
//        PrototypePatternDemo uses ShapeCache class to get clones of shapes stored in a Hashtable.
 class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        PShape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());


        PShape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        PShape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}


//        Step 5
//        Verify the output.
//
//        Shape : Circle
//        Shape : Square
//        Shape : Rectangle}