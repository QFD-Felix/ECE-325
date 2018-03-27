/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Animal} interface
 */
interface Animal {
    /**
     * An animal speaks
     */
    public void speak ();
}

/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Lion} class
 */
class Lion implements Animal {
    /**
     * The lion speaks
     */
    public void speak() {
        System.out.println("ROAR");
    }
}

/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Mouse} class
 */
class Mouse implements Animal {
    /**
     * The mouse speaks
     */
    public void speak() {
        System.out.println("SQUEAK");
    }
}

/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code Bison} class
 */
class Bison implements Animal {
    /**
     * The bison speaks
     */
    public void speak() {
        System.out.println("BELLOW");
    }
}

/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code AnimalType} class
 */
class AnimalType {
    /**
     * Create and return an animal
     * @param criteria      {@code String} how is the animal like
     * @return              {@code Animal} the animal
     */
    public static Animal getAnimal(String criteria) {
        if (criteria.equals("small"))
            return new Mouse();
        else if (criteria.equals("big"))
            return new Bison();
        else if (criteria.equals("lazy"))
            return new Lion();
        return null;
    }
}

/**
 * Lab 3: Inheritance, Interfaces, Hash, Design Pattern and Big Number <br />
 * The {@code JavaDPExample} class
 */
public class JavaDPExample {
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        AnimalType.getAnimal("small").speak();
        AnimalType.getAnimal("big").speak();
        AnimalType.getAnimal("lazy").speak();
    }
    // TODO: Lab 3 Part 3 -- Answer the design pattern questions
    /**
     * 1, Since we do not need to modify or create a new object inside the class
     * getAnimal and the main class. We used static method. 
     * 
     * 2, factory pattern
     * 
     * 3, Using the interface method, and creating each animal by separate class, leads 
     * each animal type to be easy and clear. We do not need to implement extra code to
     * specify types. This also makes us to implement the animal types thought the same
     * paten, since the same interface class is used. 
    */
}
