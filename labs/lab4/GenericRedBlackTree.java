
/**
 * Lab 4: Generics <br />
 * The {@code GenericRedBlackTree} class <br />
 * Reference: <a href="https://en.wikipedia.org/wiki/Red%E2%80%93black_tree">
 *              https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
 *            </a>
 */
public class GenericRedBlackTree<K extends Comparable<K>, V> {

    /**
     * Root node of the red black tree
     */
    private Node root = null;
    private static boolean rotateLeft = true;
    private static boolean rotateRight = false;
    /**
     * Size of the tree
     */
    private int size = 0;
    
    public Node check(Node node, K key) {
    	if (node == null || node.key == null)
    		return null;
    	else if (node.key.equals(key)) {
    		return node;
    	}
    	else {
    		if (check(node.lChild,key) != null) {
    			return node.lChild;
    		}
    		else {
    			return check(node.rChild,key);
    		}
    	}
    }
    /**
     * Search for the node by key, and return the corresponding value
     * @param key       {@code K} the key for searching
     * @return          {@code V} the value of the node, or {@code NULL} if not found
     */
    public V find(K key) {
        // TODO: Lab 4 Part 3-1 -- find an element from the tree
    	Node node = check(root,key);
    	if (node == null) {
    		return null;
    	}
    	else {
    		return node.value;
    	}
    }
    
    public void rotate(Node node, boolean direction) {
    	Node parent = node.parent;
    	Node grand = parent.parent;
    	if (grand == null)
    		root = node;
    	else {
    		if(parent.isLeft() == true) {
    			grand.lChild = node;
    		}
    		else if (parent.isRight() == true) {
    			grand.rChild = node;
    		}
    	}
    	node.parent = grand;
    	parent.parent = node;
    	if (direction == rotateLeft) {
    		parent.rChild = node.lChild;
    		if (node.lChild != null) {
    			node.lChild.parent = parent;
    		}
    		node.lChild = parent;
    	}
    	else if(direction == rotateRight) {
    		parent.lChild = node.rChild;
    		if (node.rChild != null) {
    			node.rChild.parent = parent;
    		}
    		node.rChild = parent;
    	}
    }
    public void changeColor(Node node) {
    	if (node == root) {
    		node.color = Node.BLACK;
    	}
    	else if (node.parent.color == Node.RED) {
    		Node parent = node.parent;
    		Node grand = parent.parent;
    		Node uncle;
    		if (parent.isLeft() == true) {
    			uncle = grand.rChild;
    		}
    		else {
    			uncle = grand.lChild;
    		}
    		if (uncle.color == Node.RED) {
    			uncle.color = Node.BLACK;
    			parent.color = Node.BLACK;
    			grand.color = Node.RED;
    			changeColor(grand);
    			return;
    		}
    		if (uncle.color == Node.BLACK) {
    			if (node.isLeft() && uncle.isLeft()) {
    				rotate(node,rotateRight);
    				node = node.rChild;
    			}
    			else if(node.isRight() && uncle.isRight()) {
    				rotate(node,rotateLeft);
    				node = node.lChild;
    			}
    		}
    		parent = node.parent;
    		parent.color = Node.BLACK;
    		grand.color = Node.RED;
    		
    		if (node.isLeft() && parent.isLeft()) {
    			rotate(parent,rotateRight);
    		}
    		else {
    			rotate(parent,rotateLeft);
    		}
    	}
    	
    }
    
    /**
     * Insert an element to the tree
     * @param key       {@code K} the key of the new element
     * @param value     {@code V} the value of the new element
     */
    public void insert(K key, V value) {
        // TODO: Lab 4 Part 3-2 -- insert an element into the tree
    	Node checkNode = root;
    	while (checkNode!= null && checkNode.key !=null) {
    		if (key.compareTo(checkNode.key) == 1) {
        		checkNode = checkNode.rChild;
        	}
        	else if (key.compareTo(checkNode.key) == -1) {
        		checkNode = checkNode.lChild;
        	}
        	else if(key.compareTo(checkNode.key) == 0) {
//        		checkNode.value = value;
//        		changeColor(checkNode);
        		return;
        	}
    	}
    	Node newNode = new Node(key,value);
    	if (size == 0) {
    		root = newNode;
    	}
    	else {
            Node parent = checkNode.parent;
            newNode.parent = parent;
            if (checkNode.isLeft()) {
                parent.lChild = newNode;
            } else {
                parent.rChild = newNode;
            }
        }
        size++;
        // initialize new node as red
        newNode.color = Node.RED;
        // fix red black trees color
        changeColor(newNode);
    }
    public void swapNode(Node u, Node v) {
    	K tempKey = u.key;
    	V tempValue = u.value;
    	u.key = v.key;
    	u.value = v.value;
    	v.key = tempKey;
    	v.value = tempValue;
    }
    public void changeColor_Del(Node node) {
    	if (node.parent == null) {
    		node.color = Node.BLACK;
    	}
    	else {
    		Node sibling;
            if (node.isLeft()){
                sibling = node.parent.rChild;
            } 
            else {
                sibling = node.parent.lChild;
            }
            if (sibling.color == Node.RED){
            	sibling.color = Node.BLACK;
                sibling.parent.color = Node.RED;
                if(node.isLeft()){
                    rotate(sibling, rotateLeft);
                } 
                else {
                    rotate(sibling, rotateRight);
                }
                if (node.isLeft()){
                    sibling = node.parent.rChild;
                } 
                else {
                    sibling =  node.parent.lChild;
                }
            }
            if(sibling.key == null){
                if (node.parent.color == Node.BLACK) {
                    sibling.color = Node.RED;
                    changeColor_Del(node.parent);
                }
                if (node.parent.color == Node.RED) {
                    sibling.color = Node.RED;
                    node.parent.color = Node.BLACK;
                }
            } 
            else {
                if (node.parent.color == Node.BLACK && sibling.color == Node.BLACK && sibling.lChild.color == Node.BLACK && sibling.rChild.color == Node.BLACK) {
                    sibling.color = Node.RED;
                    changeColor_Del(node.parent);
                }
                if (node.parent.color == Node.RED && sibling.color == Node.BLACK && sibling.lChild.color == Node.BLACK && sibling.rChild.color == Node.BLACK) {
                    sibling.color = Node.RED;
                    node.parent.color = Node.BLACK;
                }
            }

    		if(sibling.color == Node.BLACK) {
    			sibling.color = Node.RED;
    			if(node.isLeft() && sibling.lChild.color == Node.RED && sibling.rChild.color == Node.BLACK) {
    				sibling.lChild.color = Node.BLACK;
    				rotate(sibling.lChild,rotateRight);
    			}
    			if(node.isRight() && sibling.lChild.color == Node.BLACK && sibling.rChild.color == Node.RED){
                    sibling.rChild.color = Node.BLACK;
                    rotate(sibling.rChild, rotateLeft);
                }
    		}
    		sibling.color = node.parent.color;
            node.parent.color = Node.BLACK;
            if (node.isLeft()){
                if (sibling.rChild != null && sibling.rChild.key != null){
                    sibling.rChild.color = Node.BLACK;
                    rotate(sibling, rotateLeft);
                }
            }
            if (node.isRight()){
                if (sibling.lChild != null && sibling.lChild.key != null){
                    sibling.lChild.color = Node.BLACK;
                    rotate(sibling, rotateRight);
                }
            }
    	}
    	
    }
    public Node leftMostNode(Node node) {
    	if(node.lChild != null && node.lChild.key!=null) {
    		return leftMostNode(node.lChild);
    	}
    	else {
    		return node;
    	}
    }


    /**
     * Remove an element from the tree
     * @param key       {@code K} the key of the element
     * @return          {@code V} the value of the removed element
     */
    public V remove(K key) {
        // TODO: Lab 4 Part 3-3 -- remove an element from the trees
        Node node = check(root,key);
        if(node != null) {
        	size --;
        	return removeNode(node);
        }
        else
        	return null;
    }

    private V removeNode(GenericRedBlackTree<K, V>.Node node) {
		// TODO Auto-generated method stub
    	if (node.lChild != null && node.rChild != null && node.lChild.key != null && node.rChild.key != null) {
    		Node next_large = leftMostNode(node.rChild);
    		assert(next_large.lChild.key == null) || (next_large.rChild.key == null);
    		swapNode(next_large,node);
    		node = next_large;
    	}
    	Node child;
    	if(node.lChild != null && node.lChild.key != null) {
    		child = node.lChild;
    	}
    	else
    		child = node.rChild;
    	if(node != root && node.parent != null) {
    		child.parent = node.parent;
    		if(node.isLeft()) {
    			node.parent.lChild = child;
    		}
    		else
    			node.parent.rChild = child;
    	}
    	else if (child == null || child.key == null) {
    		root = null;
    	}
    	else {
    		root = child;
    		child.parent = null;
    	}
    	if(node.color == Node.BLACK) {
    		if(child.color == Node.RED)
    			child.color = Node.BLACK;
    		else
    			changeColor_Del(child);
    	}
    	return node.value;
	}
	/**
     * Get the size of the tree
     * @return          {@code int} size of the tree
     */
    public int size() {
        return size;
    }
    
    public String toStringRecursive(Node node) {
        if (node == null || node.value == null) {
            return "nil";
        } 
        else {
            return String.format(
                    "%s = {left %s right %s}",
                    node.toString(),
                    toStringRecursive(node.lChild),
                    toStringRecursive(node.rChild)
            );
        }
    }
    
    /**
     * Cast the tree into a string
     * @return          {@code String} Printed format of the tree
     */
    @Override public String toString() {
        // TODO: Lab 4 Part 3-4 -- print the tree, where each node contains both value and color
        // You can print it by in-order traversal

        return toStringRecursive(root);
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        GenericRedBlackTree<Integer, String> rbt = new GenericRedBlackTree<Integer, String>();
        int[] keys = new int[10];
        for (int i = 0; i < 10; i++) {
            keys[i] = (int) (Math.random() * 200);
            System.out.println(String.format("%2d Insert: %-3d ", i+1, keys[i]));
            rbt.insert(keys[i], "\"" + keys[i] + "\"");
        } // for (int i = 0; i < 10; i++)

        assert rbt.root.color == GenericRedBlackTree.Node.BLACK;
        System.out.println(rbt.root);                   // This helps to figure out the tree structure
        System.out.println(rbt);

        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("%2d Delete: %3d(%s)", i+1, keys[i], rbt.remove(keys[i])));
            if ((i + 1) % 5 == 0) {
                System.out.println(rbt);
            } // if ((i + 1) % 5 == 0)
        } // for (int i = 0; i < 10; i++)
    }


    /**
     * The {@code Node} class for {@code GenericRedBlackTree}
     */
    private class Node {
        public static final boolean BLACK = true;
        public static final boolean RED = false;

        public K key;
        public V value;
        public boolean color = BLACK;
        public Node parent = null, lChild = null, rChild = null, sibling = null;

        public Node(K key, V value) {                   // By default, a new node is black with two NIL children
            this.value = value;
            this.key = key;
            if (value != null) {
                lChild = new Node(null, null);          // And the NIL children are both black
                lChild.parent = this;
                rChild = new Node(null, null);
                rChild.parent = this;
            }
        }
        public boolean isLeft() {
            return this == this.parent.lChild;
        }
        public boolean isRight() {
        	return this == this.parent.rChild;
        }

        /**
         * Print the tree node: red node wrapped by "<>"; black node by "[]"
         * @return          {@code String} The printed string of the tree node
         */
        @Override public String toString() {
            if (value == null)
                return "";
            return (color == RED) ? "<" + value + "(" + key + ")>" : "[" + value + "(" + key + "]";
        }
    }

}
