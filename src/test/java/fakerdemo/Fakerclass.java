package fakerdemo;

import com.github.javafaker.Faker;

public class Fakerclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//faker class = documentation
		
		//http://dius.github.io/java-faker/apidocs/index.html
		
		Faker fake = new Faker();
		
		String country = fake.address().country();
		
		System.out.println ("country name :"+ country);
		
		String city = fake.address().city();
		
		System.out.println ("city name :"+ city);
		
		String firstname = fake.address().firstName();
		
		System.out.println ("first name :"+ firstname);
		
	}

}
