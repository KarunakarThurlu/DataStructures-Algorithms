package solidprinciples;


//Without Single Responsibility Principle
class EmployeeService{
	void save(Employee employee) {
		//save employee logic
	}
	
	void getEmployeeDesignation(Employee employee) {
		//Get Employee Designation logic
	}
	
	void sendNotification(Employee employee) { // Need to move separate class to satisfy (SRP)
		//Send Notification Logic
	}
	
	void generatePayslip(Employee employee) {  // Need to move separate class to satisfy (SRP)
		//Generate Pay slip Logic
	}
}

//With Single Responsibility Principle
class EmployeeServiceImpl{
	void save(Employee employee) {
		//save employee logic
	}
	
	void getEmployeeDesignation(Employee employee) {
		//Get Employee Designation logic
	}
}

class NotificationServiceImpl{
	void sendNotification(Employee employee) {
		//Send Notification Logic
	}
}

class PayslipServiceImpl{
	void generatePayslip(Employee employee) {
		//Generate Pay slip Logic
	}
}
class Employee{
	
	private int id;
	private String name;
	private double salary;
	private String designation;
	
	public Employee() {
		super();
	}
	
	//Setters & Getters 
}

public class SingleResponsibilityPrinciple {
	//Definition: A class should have only one reason to change, meaning it should have one job or responsibility.
	//Benefit: Makes the class easier to understand, test, and maintain.
	//Example: If a class handles both logging and business logic, it violates SRP. Splitting the responsibilities into two separate classes improves clarity and maintainability.
}


