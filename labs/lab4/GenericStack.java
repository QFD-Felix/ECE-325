import java.util.*;
/**
 * Lab 4: Generics <br />
 * The {@code GenericStack} class
 */
public class GenericStack<T>extends Vector<T>{
	public GenericStack() {
		super(0,1);
	}

    /**
     * Query the top element
     * @return          {@code T} the top element
     */
	
    public T peek() {
        // TODO: Lab 4 Part 1-1 -- GenericStack, finish the peek method
    	if (this.isEmpty()) {
    		return null;
    	}
    	else {
    		return this.get(this.size()-1);
    	}
    }

    /**
     * Add a new element as top element
     * @param value     {@code T} the new element
     */
    public void push(T value) {
        // TODO: Lab 4 Part 1-2 -- GenericStack, finish the push method
        this.add(value);
    }

    /**
     * Remove the top element
     * @return          {@code T} the removed element
     */
    public T pop() {
        // TODO: Lab 4 Part 1-3 -- GenericStack, finish the pop method
        if (this.isEmpty()) {
        	return null;
        }
        else {
        	return this.remove(this.size()-1);
        }
    }

    /**
     * Query the size of the stack
     * @return          {@code int} size of the element
     */
    public int size() {
        // TODO: Lab 4 Part 1-4 -- GenericStack, finish the size method
        int size = 0;
    	for(T element: this) {
        	size++;
        }
    	return size;
    }

    /**
     * Check if the stack is empty of not
     * @return          {@code boolean} {@code true} for empty; {@code false} for not
     */
    public boolean isEmpty() {
        // TODO: Lab 4 Part 1-5 -- GenericStack, finish the isEmpty method
        if (this.size() == 0){
        	return true;
        }
        return false;
    }

    /**
     * Calculate a postfix expression
     * @param exp       {@code String} the postfix expression
     * @return          {@code Double} the value of the expression
     */
    public static Double calcPostfixExpression(String exp) {
        // TODO: Lab 4 Part 1-6 -- GenericStack, calculate postfix expression
        GenericStack<Double>clc = new GenericStack<Double>();
        for (String expSym : Arrays.asList(exp.split(" "))) {
        	if(expSym.matches("\\d")) {
        		clc.push(Double.parseDouble(expSym));
        	}
        	else if (expSym.matches("\\+"
        			+ "||\\-"
        			+ "||\\*"
        			+ "||\\/"
        			+ "||\\^")) {
        		clc.push(calculation(clc,expSym));
        	}
        }
        return clc.pop();
    }
    
    public static Double calculation(GenericStack<Double>exp, String operator) {
    	if (exp.size()<2) {
    		return null;
    	}
    	else {
    		Double num1 = exp.pop();
    		Double num2 = exp.pop();
    		if (operator.equals("+")) {
    			return num1+num2;
    		}
    		else if (operator.equals("-")) {
    			return num2-num1;
    		}
    		else if (operator.equals("*")) {
    			return num1*num2;
    		}
    		else if (operator.equals("/")) {
    			return num2/num1;
    		}
    		else if (operator.equals("^")) {
    			return Math.pow(num2, num1);
    		}
    		return null;
    	}
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String[] expressions = {
                "4 1 +",                    // 1: = 5
                "2 6 -",                    // 2: = -4
                "3 3 *",                    // 3: = 9
                "1 4 /",                    // 4: = 0.25
                "2 3 ^",                    // 5: = 8
                "2 1 + 4 * 8 - 3 ^ 6 -",    // 6: 58
        }; // String[] expressions = { ... };
        for (String s: expressions)
            System.out.println(s + " = " + calcPostfixExpression(s));
    }

}
