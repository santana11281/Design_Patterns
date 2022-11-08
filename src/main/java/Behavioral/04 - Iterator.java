package Behavioral;


//        Step 1
//        Create interfaces.
interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator getIterator();
}


//Step 2
//        Create concrete class implementing the Container interface. This class has inner class NameIterator implementing the Iterator interface.
class NameRepository implements Container {
    public String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {

        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            return index < names.length;
        }

        @Override
        public Object next() {

            return hasNext() ? names[index++] : null;
        }
    }
}


//        Step 3
//        Use the NameRepository to get iterator and print names.
class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}


//        Step 4
//        Verify the output.
//
//        Name : Robert
//        Name : John
//        Name : Julie
//        Name : Lora