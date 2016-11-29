package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import base.PersonDAL;

public class Person_Test {
		
	private static PersonDomainModel person1;
	private static UUID person1UUID = UUID.randomUUID();			
	
	@BeforeClass
	public static void personInstance() throws Exception{
		
		Date person1Birth = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		 person1 = new PersonDomainModel();
		 
		try {
			person1Birth = dateFormat.parse("1994-11-27");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		person1.setPersonID(person1UUID);
		person1.setFirstName("Mingkun");
		person1.setMiddleName("a");
		person1.setLastName("Chen");
		person1.setBirthday(person1Birth);
		person1.setCity("Elkton");
		person1.setStreet("702 Stone Gate Blvd");
		person1.setPostalCode(21921);
		System.out.print(person1.getPersonID().toString()+ "THIS IS IT");
		
	}
	
	
	@Test
	public void AddPersonTest() {
		
		PersonDAL.addPerson(person1);
		PersonDomainModel personForTesting = PersonDAL.getPerson(person1UUID);
		assertNotNull(personForTesting);
}
	
	@Test
	public void UpdatePersonTest() {
		PersonDAL.addPerson(person1);
		person1.setFirstName("lol");
		PersonDAL.updatePerson(person1);
		String s = PersonDAL.getPerson(person1UUID).getFirstName();
		assertEquals(s, "lol");


}
	
	@Test
	public void DeletePersonTest() {
		PersonDAL.addPerson(person1);
		assertNotNull(PersonDAL.getPerson(person1UUID));
		PersonDAL.deletePerson(person1UUID);
		assertNull(PersonDAL.getPerson(person1UUID));

}
	
	
	@After
	public void cleanUp() throws Exception {
		if (PersonDAL.getPerson(person1UUID) != null)
		{  
			PersonDAL.deletePerson(person1UUID);
		} else { }
		assertNull(PersonDAL.getPerson(person1UUID));
	}
}
