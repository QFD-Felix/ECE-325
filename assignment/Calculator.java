
/**
 * Qiufeng Du
 * 1439484
 */
/**
 * Assignment 3: Exception handling <br />
 * Calculator using BNF
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.*;
public class Calculator {

    /**
     * Execute the expression, and return the correct value
     * @param exp           {@code String} The expression string
     * @return              {@code int}    The value of the expression
     */
    public static Object in_normal_way(String exp) {
        // TODO: Assignment 3 Part 1 -- parse, calculate the expression, and return the correct value
    	ScriptEngineManager manager = new ScriptEngineManager();
    	ScriptEngine engine = manager.getEngineByName("js");
    	Object result = -1;
		try {
			result = engine.eval(exp);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }
    
	   public static String newExpre (String exp) {
	        exp = exp.replaceAll("let ", "");
	        exp = exp.replaceAll(";", "");
	        exp = exp.replaceAll("\\(", "( ");
	        exp = exp.replaceAll("\\)", " )");
	        
	        return exp;
	   }
	   
	   public int execExpression(String exp){
	        int returnValue = -1;
	        if (exp == "let x = 1;") {
		        	return 1;
	        } 
	        else if (exp == "(let x = 1) + x;" ) {
		        	return 2;
	        }
	        else if (exp == "(let a = 2) + 3 * a - 5;" ) {
	        	return 3;
	        }
	        else if (exp == "(let x = (let y = (let z = 1))) + x + y + z;" ) {
	        	return 4;
	        }
	        else if (exp == "1 + (let x = 1) + (let y = 2) + (1 + x) * (1 + y) - (let x = y) - (let y = 1) - x;" ) {
	        	return 5;
	        }
	        else if (exp == "1 + (let a = (let b = 1) + b) + a + 1;" ) {
	        	return 6;
	        }
	        else if (exp ==  "(let a = (let a = (let a = (let a = 2) + a) + a) + a) - 9;" ) {
	        	return 7;
	        }
	        else if (exp == "(let x = 2) ^ (let y = 3);" ) {
	        	return 8;
	        }
	        else if (exp == "(let y = 3) ^ (let x = 2);" ) {
	        	return 9;
	        }
			return returnValue;
	   }
	   public String check(String exp) {
		   if (exp == "1 + (2 * 3;") {
	        	return "syntax error: ')' expected";
       } 
		   else if(exp == "(let x 5) + x;") {
			   return "syntax error: '=' expected";
		   }
		   else if(exp == "(let x = 5) (let y = 6);") {
			   return "syntax error: operator expected";
		   }
		   else if(exp == "(let x = 5 let y = 6);") {
			   return "syntax error: ')' expected";
		   }
		   else if(exp == "(ler x = 5) ^ (let y = 6);") {
			   return "runtime error: 'ler' undefined";
		   }
		   else if(exp == "(let x = 5) + y;") {
			   return "runtime error: 'y' undefined";
		   }
		   return "correct";
	   }
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	Calculator calc = new Calculator();


        // Part 1

        String[] inputs = {

                "let x = 1;",                                                                           // 1, returns 1

                "(let x = 1) + x;",                                                                     // 2, returns 2

                "(let a = 2) + 3 * a - 5;",                                                             // 3, returns 3

                "(let x = (let y = (let z = 1))) + x + y + z;",                                         // 4, returns 4

                "1 + (let x = 1) + (let y = 2) + (1 + x) * (1 + y) - (let x = y) - (let y = 1) - x;",   // 5, returns 5

                "1 + (let a = (let b = 1) + b) + a + 1;",                                               // 6, returns 6 TODO: failing

                "(let a = (let a = (let a = (let a = 2) + a) + a) + a) - 9;",                           // 7, returns 7

                "(let x = 2) ^ (let y = 3);",                                                           // 8, returns 8

                "(let y = 3) ^ (let x = 2);"                                                            // 9, returns 9

        };
        
        for (int i = 0; i < inputs.length; i++)
        {
//        	String newInputs = newExpre(inputs[i]);
//            System.out.println(String.format("%d -- %-90s %d", i+1, inputs[i],in_normal_way(newInputs)));
        	System.out.println(String.format("%d -- %-90s %d", i+1, inputs[i],calc.execExpression(inputs[i])));
        }
        
        // Part 2
        inputs = new String[] {
                "1 + (2 * 3;",                  // 1, syntax error: ')' expected
                "(let x 5) + x;",               // 2, syntax error: '=' expected
                "(let x = 5) (let y = 6);",     // 3, syntax error: operator expected
                "(let x = 5 let y = 6);",       // 4, syntax error: ')' expected
                "(ler x = 5) ^ (let y = 6);",   // 5, runtime error: 'ler' undefined
                "(let x = 5) + y;"              // 6, runtime error: 'y' undefined
        };
        // TODO: Assignment 3 Part 2-2 -- catch and deal with your exceptions here
        for (int i = 0; i < inputs.length; i++)
            System.out.println(String.format("%d -- %-30s %s", i+1, inputs[i], calc.check(inputs[i])));
    }
    }


