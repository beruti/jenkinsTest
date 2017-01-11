// name package - the master class
package com.deloitte.people.directory;

// import all relevant utilities
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// import com.deloitte.people.*
// import classes
import com.deloitte.people.Address;
import com.deloitte.people.Employee; // the two packages are not related to each other could do people.*

public class EmployeeDirectory {
	// designate main method of class
	public static void main (String...args){
		// create multiple employees, one at a time
		// construct an employee object and construct their Address
		// assign to named variable
		// state that named variable is of the class/type Employee
		Employee Jiawei = new Employee ("jiawei","huo",new Address ("flat 1","98 farringdon","london","London","EC2R 3EA"),UUID.randomUUID().toString());//UUID could generate random id
		Employee garageGirl = new Employee ("garage","girl",new Address ("jiji","lala","london","London","EC2R 3EA"),UUID.randomUUID().toString());
		Employee rooflady = new Employee ("roof","lady",new Address ("fsfs","ewew","london","London","EC2R 3EA"),UUID.randomUUID().toString());
		EmployeeDirectory directory = new EmployeeDirectory();
		// call methods
		directory.addDepartment("Manager");
		directory.addEmployeeToDepartment(Jiawei, "Manager");
		directory.addEmployeeToDepartment(garageGirl, "Manager");
		directory.addEmployeeToDepartment(rooflady, "Manager");
		// iterate over employees one by one
		for (Employee e:directory.getEmployeeInDepartment("Manager")){
			//e is just a local variable which you could just use and it is declared itself
			System.out.println(e.getFirstName() + "" + e.getLastName());
		}

	}

	private Map <String, List<Employee>> departmentMap; //map is an interface

	public EmployeeDirectory () {
		//HashMap maintains key and value pairs and often denoted as HashMap<Key, Value> or HashMap<K, V>.
		// HashMap implements Map interface.
		//HashMap is similar to Hashtable with two exceptions
		//– 1 HashMap methods are unsynchronized and 2 it allows null key and null values unlike Hashtable.
		departmentMap = new HashMap <> (); //hashmap implement the map there are different implementation of the map
	}

	public void addDepartment (String departmentName){

		//		List<Employee> emptyEmployeeList = new ArrayList<>(); //super explicit
		// Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null.
		// In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list.
		// (This class is roughly equivalent to Vector, except that it is unsynchronized.)

		departmentMap.put(departmentName, new ArrayList<Employee>());
	}

	public void removeDepartment (String departmentName){
		departmentMap.remove(departmentName); // remove the entire row
	}

	public void addEmployeeToDepartment (Employee employee, String departmentName){
		//departmentMap.get(departmentName).add(employee); //if this is an invalid department name then it will return null which will call the add function
		// the type will be just employee as we defined  as a generic class
		//if we have one more variable for that then it is not copying the list as java deals with the address reference it just added a reference
		try {
			List<Employee> employees = getEmployeeInDepartment(departmentName);
			employees.add(employee);
		} catch (departmentDoesNotExsistException e){ //assign this to an variable
			System.err.println("Department Does Not Exsis");  err? and the constant what does it mean //we have thrown an exception so we need to catch // you could have more catch blocks
		}
		//		finally {
		//			//this will always run even there is no match //finally will always go first the next line of the code
		//		}
	}

	public List<Employee> getEmployeeInDepartment (String departmentName) throws departmentDoesNotExsistException{ //throws means you may throw
		if (!departmentMap.containsKey(departmentName)){ ????contains the key
				throw new departmentDoesNotExsistException();//throw means it will throw
		}
		return departmentMap.get(departmentName); //duplication of get then you could reuse the the code you just created
	}
}
