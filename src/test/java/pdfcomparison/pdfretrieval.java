package pdfcomparison;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class pdfretrieval {
	
	static String actualpdf = "C:\\Users\\ACER\\OneDrive\\Desktop\\Claims Payments\\PDFCompare\\Doc1.pdf";
	static String expectedtext = "Usage of pdf comparison :- It helps to compare two pdf based on the two pdf content ";
	static String expectedtexet = "not text";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Loading an existing document
	      File file = new File(actualpdf);
	      PDDocument document = PDDocument.load(file);

	      //Instantiate PDFTextStripper class
	      PDFTextStripper pdfStripper = new PDFTextStripper();

	      //Retrieving text from PDF document
	      String text = pdfStripper.getText(document);
	      System.out.println(text);
	      
	     boolean expected =  text.contains(expectedtext);
	     
//	     int value = text.indexOf(expectedtext, 5);
//	     System.out.println ("value stored :" + value) ;
	     
	     if (!expected) {
	    	 System.out.println ("pdf etreived text notequals") ;
	     }else {
	    	 System.out.println ("pdf retreived text is   equal") ;
	     }
	     
	     
	    //Closing the document
	      document.close();

	}

}
