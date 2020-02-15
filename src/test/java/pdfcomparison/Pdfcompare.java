package pdfcomparison;

import java.io.IOException;

import de.redsix.pdfcompare.PdfComparator;

//git hub url - https://github.com/red6/pdfcompare/tree/master/src 

//download verifypdftotext comparison - http://www.verypdf.com/app/pdf-to-txt-converter/try-and-buy.html#buy-cvt
//to get the pdf pixels 


public class Pdfcompare {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String actualpdf = "C:\\Users\\ACER\\OneDrive\\Desktop\\Claims Payments\\PDFCompare\\Doc1.pdf";

		String expectedpdf = "C:\\Users\\ACER\\OneDrive\\Desktop\\Claims Payments\\PDFCompare\\Doc2.pdf";
		
		String resultpdf = "C:\\Users\\ACER\\OneDrive\\Desktop\\Claims Payments\\PDFCompare\\Results\\Results.pdf";
		
		//pdf comparator to compare two pdf 
		new PdfComparator(expectedpdf, actualpdf).compare().writeTo(resultpdf);
		
		System.out.println ("Process completed");
		
		boolean isEquals = new PdfComparator(expectedpdf, actualpdf).compare().writeTo(resultpdf);
		if (!isEquals) {
		    System.out.println("Differences found!");
		}
		
		new PdfComparator(expectedpdf, actualpdf).withIgnore("ignore.conf").compare();
		
		

	}

}
