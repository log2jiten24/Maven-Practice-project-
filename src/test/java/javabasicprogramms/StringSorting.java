package javabasicprogramms;

import java.util.ArrayList;
import java.util.List;

public class StringSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List <String> al = new ArrayList<String> (); 
		
		String str = "Jiten,Priya,Aadya,Khushi" ;
		String sorted = "APJK" ;
		
	    String arrays [] = str.split(",");
	    //it will return array of characters 
	    char[]characterarray = sorted.toCharArray();
	    
	    for (int i = 0 ; i < characterarray.length ; i ++ ) {
	    	
	    	for (String sortedarray :  arrays) {
	    		
	    	if ( characterarray[i] == sortedarray.charAt(0)) {
	    		
	    		al.add(sortedarray);
	    	}
	    		}
	    }
		System.out.println ("Sorted array is : " + al );
	}

}

//output == Sorted array is :[Aadya, Priya, Jiten, Khushi]
