/**
 * Lab 2: Debugging with Eclipse and Red Black Tree) <br />
 * The {@code RedBlackTree} class of integers only <br />
 * Reference: <a href="https://en.wikipedia.org/wiki/Red%E2%80%93black_tree">
 *              https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
 *            </a>
 */
public class RedBlackTree {

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

    /**
     * Search the tree to find if the value is contained
     * @param value     {@code int} the value to be checked
     * @return          {@code boolean} If contains, return {@code true}, otherwise return {@code false}
     */
    public boolean check(Node node, int value) {
    	if (node == null || node.value == null)
    		return false;
    	else if (node.value == value) {
    		return true;
    	}
    	else {
    		if (check(node.lChild,value) == true) {
    			return true;
    		}
    		else {
    			return check(node.rChild,value);
    		}
    	}
    }
    public boolean contains(int value) {
        // TODO: Lab 2 Part 2-1 -- find an integer from the tree
        return check(root,value);
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
     * Insert an integer to the tree
     * @param data      {@code int} New element to be inserted
     */
    public void insert(int value) {
        // TODO: Lab 2 Part 2-2 -- insert an integer into the tree
    	Node checkNode = root;
    	while (checkNode!= null && checkNode.value !=null) {
    		if (value>checkNode.value) {
        		checkNode = checkNode.rChild;
        	}
        	else if (value<checkNode.value) {
        		checkNode = checkNode.lChild;
        	}
        	else if(value == checkNode.value) {
        		return;
        	}
    	}
    	Node newNode = new Node(value);
    	if (size == 0) {
    		root = newNode;
    	}
    	else {
            Node parent = checkNode.parent;
            newNode.parent = parent;
            if (checkNode == parent.lChild) {
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
    @Override
    public String toString() {
        // TODO: Lab 2 Part 2-3 -- print the tree, where each node contains both value and color
        // You can print it by in-order traversal
        return toStringRecursive(root);
    }
    
    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        for (int i = 0; i < 10; i++)
            rbt.insert((int) (Math.random() * 200));

        assert rbt.root.color == RedBlackTree.Node.BLACK;
//        System.out.println(rbt.root);           // This helps to figure out the tree structure
          System.out.println(rbt);
    }


    /**
     * The {@code Node} class for {@code RedBlackTree}
     */
    private class Node {
        public static final boolean BLACK = true;
        public static final boolean RED = false;

        public Integer value;
        public boolean color = BLACK;
        public Node parent = null, lChild = null, rChild = null;

        public Node(Integer value) {             // By default, a new node is black with two NIL children
            this.value = value;
            if (value != null) {
                lChild = new Node(null);         // And the NIL children are both black
                lChild.parent = this;
                rChild = new Node(null);
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
            return (color == RED) ? "<" + value + ">" : "[" + value + "]";
        }
    }

}
