
/**
 * Qiufeng Du
 * 1439484
 */

/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */

import java.util.Calendar;
import java.text.ParseException;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
public class daysold {
    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) {
        // TODO: Assignment 1 -- write your code here.
    	
    	//Convert the birthday(string) to birthDate(Date).
    	SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
    	Date birthDate = new Date();
		try {
			birthDate = smp.parse(birthday);
		} catch (ParseException e) {
			System.out.println("wrong format");;
		}
		
		
		//Covert the birthDate to a string which is the final form.
		SimpleDateFormat fsmp = new SimpleDateFormat("MMMM dd yyyy", Locale.CANADA);
    	String str_birthDate = fsmp.format(birthDate);
    	Date now = new Date();
    	String str_now = fsmp.format(now);
    	
    	
    	//Calculate the age by using milliseconds.
    	//Calendar.getTimeInMillis() will give us the information in milliseconds.
    	Calendar birth = new GregorianCalendar();
    	birth.setTime(birthDate);
    	Calendar currtime = new GregorianCalendar();
    	long milliseconds = currtime.getTimeInMillis()-birth.getTimeInMillis();
    	int result = (int)(milliseconds/(1000*60*60*24));
    	
    	
    	//Check the legality of the date information.
    	//Print out the final result.
    	if (checkDate(birthday) && result>=0) {
    		System.out.println("Birthday: " + str_birthDate + "; today: " + str_now + " -- " +"You are "+ result+" days old.");
    	}
    	else {
    		System.out.println("Birthday: " + str_birthDate + "; today: " + str_now + " -- Wrong birthday!");
    	}
    } 
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static boolean checkDate(String someDate) {
    	//This is a boolean function.
    	//return: True if it is a legal date.
    	//		  False if it is not a legal date.
		SimpleDateFormat check_format = new SimpleDateFormat("yyyy-MM-dd");
		check_format.setLenient(false);
		try {
			check_format.parse(someDate.trim());
		}
		catch(ParseException pe){
			return false;
		}
		return true;
	}

    public static void main(String[] args) {
        days("2000-1-1");
        days("3000-1-1");           // This is a wrong birthday
    } // public static void main(String[] args)

}
