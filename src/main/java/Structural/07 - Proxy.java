package Structural;

//        Step 1
//        Create an interface.
 interface Image {
    void display();
}


//        Step 2
//        Create concrete classes implementing the same interface.
 class RealImage implements Image {

    private final String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}


 class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}


//        Step 3
//        Use the ProxyImage to get object of RealImage class when required.
 class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}


//        Step 4
//        Verify the output.
//        Loading test_10mb.jpg
//        Displaying test_10mb.jpg
//        Displaying test_10mb.jpg