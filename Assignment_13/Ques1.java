import java.util.*;

public class Ques1 {

    public static HashMap<String, String> dateValue = new HashMap<String, String>();
    public static HashMap<String, String> monthValue = new HashMap<String, String>();

    static {     
	dateValue.put("01", "First ");
	dateValue.put("02", "Second ");
	dateValue.put("03", "Third ");
	dateValue.put("04", "Fourth ");
	dateValue.put("05", "Fifth ");
	dateValue.put("06", "Sixth ");
	dateValue.put("07", "Seventh ");
	dateValue.put("08", "Eighth ");
	dateValue.put("09", "Nineth ");
	dateValue.put("10", "Tenth ");
	dateValue.put("11", "Eleventh ");
	dateValue.put("12", "Tweleveth ");
	dateValue.put("13", "Thirteenth ");
	dateValue.put("14", "Fourteenth ");
	dateValue.put("15", "Fifteenth ");
	dateValue.put("16", "Sixteenth ");
	dateValue.put("17", "Seventeenth ");
	dateValue.put("18", "Eighteenth ");
	dateValue.put("19", "Nineteenth ");
	dateValue.put("20", "Twenty ");
	dateValue.put("21", "Twenty First ");
	dateValue.put("22", "Twenty Second ");
	dateValue.put("23", "Twenty Third ");
	dateValue.put("24", "Twenty Fourth ");
	dateValue.put("25", "Twent Fifth ");
	dateValue.put("26", "Twenty Sixth ");
	dateValue.put("27", "Twenty Seventh ");
	dateValue.put("28", "Twenty Eighth ");
	dateValue.put("29", "Twenty Nineth ");
	dateValue.put("30", "Thirty ");
	dateValue.put("31", "Thirty First ");

	monthValue.put("01", "January ");
	monthValue.put("02", "February ");
	monthValue.put("03", "March ");
	monthValue.put("04", "April ");
	monthValue.put("05", "May ");
	monthValue.put("06", "June ");
	monthValue.put("07", "July ");
	monthValue.put("08", "August ");
	monthValue.put("09", "September ");
	monthValue.put("10", "October ");
	monthValue.put("11", "November ");
	monthValue.put("12", "December ");
    }
    
    public static String convertToWords(String n)
    {
        int num = Integer.valueOf(n);
        String one[] = {" ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ",
                        "Eight" , "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ",
                        "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
                        "Nineteen " };
        
        String ten[] = {" ", " ", "Twenty", "Thirty", "Forty", "Fifty",
                        "Sixty", "Seventy", "Eighty", "Ninety" };
        
        if (num > 19){
            String result = (ten[num / 10] + " " + one[num % 10]);
            return result;
        } 
        else{
            return (one[num]);
        }
    }
    
    public static String convertDate(String date) {
        String result = "";
	String d = date.substring(0, 2);
	String m = date.substring(3, 5);
	String yL = date.substring(6, 8);
	String yR = date.substring(8, 10);
        result += dateValue.get(d);
        result += monthValue.get(m);
        result += convertToWords(yL);
        if(yR.equals("00")){
            result += "hundred";
        }
        else{
        result += convertToWords(yR);
        }
	return result;
    }

    public static void main(String args[]) {
	String date = "25-06-1998";
        System.out.println(convertDate(date));
    }
}