import java.util.*;
/**
 * Lab 6: Java Collection Framework, Skip List and Apache ANT <br />
 * The {@code SkipList} class
 * @param <K>           {@code K} key of each skip list node
 * @param <V>           {@code V} value of each skip list node
 */
public class SkipList<K extends Comparable<K>, V> {
	private Random rand = new Random();
    private Node top = new Node(null, null, 0);
    private ArrayList<Node> new_list;

    /**
     * The {@code Node} class for {@code SkipList}
     */
    private class Node {
        public K key;
        public V value;
        public ArrayList<Node> forwards = new ArrayList<>();

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            for (int i = 0; i <= level; i++)
                forwards.add(null);
        }

        public String toString() {
            return String.format("%s", value);
        }
    }
    
    private int randomLevel() {
        int ram_Level = 0;
        while (rand.nextFloat() < 0.5)
            ram_Level++;
        ram_Level = Integer.min(ram_Level, level() + 1);
        return ram_Level;
    }
    
    /**
     * Level of the skip list. An empty skip list has a level of 1
     */
    private int level = 0;

    /**
     * Size of the skip list
     */
    private int size = 0;
    
    /**
     * Insert an new element into the skip list
     * @param key       {@code K} key of the new element
     * @param value     {@code V} value of the new element
     */
    public void insert(K key, V value) {
    	int inseartLevel = randomLevel();
        if (findKey(key) != null) {
            return;
        }
        else {
        	if (inseartLevel > level) {
                Node tmp_top = new Node(null, null, inseartLevel);
                for (int i = 0; i <= level; i++) {
                    tmp_top.forwards.set(i, top.forwards.get(i));
                }
                top = tmp_top;
                level = inseartLevel;
            }
            findKey(key);
            Node inseartNode = new Node(key, value, inseartLevel);
            for (int i = 0; i <= inseartLevel; i++) {
                inseartNode.forwards.set(i, new_list.get(i).forwards.get(i));
                new_list.get(i).forwards.set(i, inseartNode);
            }
        }
        size++;
    }
    
    /**
     * Remove an element by the key
     * @param key       {@code K} key of the element
     * @return          {@code V} value of the removed element
     */
    public V remove(K key) {
        // TODO: Lab 5 Part 1-2 -- skip list deletion
    	Node target = findKey(key);
        if (findKey(key) != null) {
        	for (int i = 0; i<level; i++) {
        		new_list.get(i).forwards.set(i, target.forwards.get(i));
        		if (new_list.get(i).forwards.get(i) != target) {
        			break;
        		}
        	}
        	while (level>0 && top.forwards.get(level) == null) {
            	level--;
            }
        	size--;
            return target.value;
        }
        else
        	return null;
    }
    
    private Node findKey(K key) {
        new_list = new ArrayList<>();
        Node check = top;
        for (int i = 0; i <= level; i++) {
            new_list.add(null);
        }
        for (int i = level(); i>=0; i--) {
            while (check.forwards.get(i) != null && key.compareTo(check.forwards.get(i).key) > 0)
                check = check.forwards.get(i);
            new_list.set(i, check);
        }
        check = check.forwards.get(0);
        if (check != null && key.equals(check.key)) {
            return check;
        } else {
            return null;
        }
    }
    /**
     * Search for an element by the key
     * @param key       {@code K} key of the element
     * @return          {@code V} value of the target element
     */
    public V search(K key) {
        // TODO: Lab 5 Part 1-3 -- skip list node search
    	Node target = findKey(key);
        if(target != null)
            return target.value;
        return null;
    }



    /**
     * Get the level of the skip list
     * @return          {@code int} level of the skip list
     */
    public int level() {
        return level;
    }

    /**
     * Get the size of the skip list
     * @return          {@code int} size of the skip list
     */
    public int size() {
        return size;
    }
    /**
     * Print the skip list
     * @return          {@code String} the string format of the skip list
     */
    public String toString() {
        // TODO: Lab 5 Part 1-4 -- skip list printing
    	 StringBuilder printer = new StringBuilder();
         for (int i = 0; i <= level; i++) {
             printer.append(String.format("Level: %d", i));
             printer.append(printLevel(top.forwards.get(i),i));
             printer.append("\n");
         }
         return printer.toString();
    }
    private String printLevel(Node node, int level) {
    	if (node == null || node.value == null) {
    		return null;
    	}
    	else {
    		return String.format("%s --> %s", String.valueOf(node),printLevel(node.forwards.get(level),level));
    	}
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        SkipList<Integer, String> list = new SkipList<Integer, String>();
        int[] keys = new int[10];
        for (int i = 0; i < 10; i++) {                          // Insert elements
            keys[i] = (int) (Math.random() * 200);
            list.insert(keys[i], "\"" + keys[i] + "\"");
        }

        System.out.println(list);

        for (int i = 0; i < 10; i += 3) {
            int key = keys[i];
            // Search elements
            System.out.println(String.format("Find element             %3d: value=%s", key, list.search(key)));
            // Remove some elements
            System.out.println(String.format("Remove element           %3d: value=%s", key, list.remove(key)));
            // Search the removed elements
            System.out.println(String.format("Find the removed element %3d: value=%s", key, list.search(key)));
        }

        System.out.println(list);
    }

}