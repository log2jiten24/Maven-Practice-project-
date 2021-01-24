//package javabasicprogramms;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class OccurenceofCharacters {
//	
//	public static void main (String [] args) {
//		
//	String str = "aaaaab aaaaaaaa" ;
//	
//	char[] c = str.toCharArray();
//	
//	Map<Character,Integer> alllist = new HashMap<Character,Integer >();
//	
//	for (int i = 0 ; i < c.length ; i ++ ) {
//	
//		if (alllist.keySet().contains(c[i])) {
//			
//			int counter = alllist.get(c[i]);
//			
//			counter = counter + 1;
//			
//			alllist.put(c[i], counter);
//		}else {
//			
//			alllist.put(c[i], 1);
//		}
//			}
//			
//	for (int i = 0 ; i < c.length ; i ++) {
//		
//		if (alllist.get(c[i]) == 1) {
//			
//			System.out.println (c[i]);
//		}
//	}
//	
//   }	
//}
//
