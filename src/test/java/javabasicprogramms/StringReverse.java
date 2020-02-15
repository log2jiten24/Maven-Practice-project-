package javabasicprogramms;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello#1234" ;
		
		System.out.println ("the input String is :" + str) ;
		
		System.out.println ("the output String is : " + reversal(str)) ;
		
		}

	
	public static String reversal(String s) 
	{
		
		String [] str = s.split("#");
		System.out.println ("the splitted string :" + str[0] + "the second part :" + str[1]) ;
		
		String finalresult = reversalString(str[0]) + " " +  "#" + " " + reversalString(str[1]) ;
		
		return finalresult ;	
	}
	
	public static String reversalString (String splitted) {
		
		String s = " " ;
		//first part - condition start , condition evaluation , condition increment 
		for (int i = splitted.length()-1 ; i >= 0 ; i -- )
		{
		System.out.println ("each string character :" + splitted.charAt(i)) ;	
		s = s  + splitted.charAt(i)	;
		System.out.println ("reversal string :" + s) ;
		}
		return s;
		
	}
}
