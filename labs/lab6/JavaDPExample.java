import java.util.*;

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Animal} interface
 */
interface Animal {
    /**
     * An animal speaks
     */
    public void speak ();
}
/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
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
 * Lab 6: Anonymous Inner Classes and Reflection <br />
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
 * Lab 6: Anonymous Inner Classes and Reflection <br />
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

class Dog implements Animal {
    /**
     * The bison speaks
     */
    public void speak() {
        System.out.println("WOOF");
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code AnimalType} class
 */
class AnimalType {
	public static HashMap<String, Class<?>> AnimalMap = new HashMap<String, Class<?>>();
	public static void add(String cri, Class animal) {
		AnimalMap.put(cri, animal);
	}
	public static void remove(String cri) {
		AnimalMap.remove(cri);
	}
    /**
     * Create and return an animal
     * @param criteria      {@code String} how is the animal like
     * @return              {@code Animal} the animal
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static Animal getAnimal(String criteria) throws InstantiationException, IllegalAccessException {
        // TODO: Lab 6 Part 2-1 -- Refactor this method
        Class newAnimal = AnimalMap.get(criteria);
        return (Animal)newAnimal.newInstance();
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code JavaDPExample} class
 */
public class JavaDPExample {
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    	AnimalType.add("small",Mouse.class);
    	AnimalType.add("big", Lion.class);
    	AnimalType.add("lazy", Bison.class);
        AnimalType.getAnimal("small").speak();
        AnimalType.getAnimal("big").speak();
        AnimalType.getAnimal("lazy").speak();

        // TODO: Lab 6 Part 2-2 -- add an animal "Dog" here: criteria="loyal"; speak="woof"
        AnimalType.add("loyal", Dog.class);
        AnimalType.getAnimal("loyal").speak();

        // TODO: Lab 6 Part 2-3 -- remove the "small" animal here: Mouse
        AnimalType.remove("small");
        try {
            AnimalType.getAnimal("small").speak();
        } catch (Exception e) {
            System.out.println("Unkwon animal...");
        }
    }
}
