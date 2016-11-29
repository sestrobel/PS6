package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import domain.StudentDomainModel;

public class Student_Test {
	private static StudentDomainModel person1;	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date person1Birth = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		person1 = new StudentDomainModel();
		 
		try {
			person1Birth = dateFormat.parse("1994-11-27");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		person1.setFirstName("Mingkun");
		person1.setMiddleName("a");
		person1.setLastName("Chen");
		person1.setDOB(person1Birth);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(1==1);
		System.out.print(StudentDAL.getStudents() + "THIS IS IT FIND ME 1!!");
		StudentDAL.addStudent(person1);
		System.out.print(StudentDAL.getStudents() + "THIS IS IT FIND ME 2!!");
		StudentDAL.deleteStudent(person1.getStudentID());
		System.out.print(StudentDAL.getStudents() + "THIS IS IT FIND ME 3!!");


//		StudentDAL.addStudent(person1);
//		StudentDAL.deleteStudent(person1.getStudentID());

	}

}
