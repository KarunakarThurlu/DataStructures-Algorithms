package solidprinciples;

import java.util.List;


interface EmpService {
    Employee addEmployee(Employee employee);
    Employee fetchEmployee(Employee employee);
    List<Employee> fetchAllEmployees();
    String deleteEmployee(Integer id);
    Employee upEmployee(Employee employee);
}

class EmpServiceImpl implements EmpService {

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee fetchEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee upEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}

//Without Dependency Inversion Principle
class EmployeeController{
	
	//@Autowired
	private EmpServiceImpl empServiceImpl; //Here EmpController class directly depending on EmpServiceImpl class
	
	
	public String addEmployee(Employee employee) {
		empServiceImpl.addEmployee(employee);
		return "Emp Added Successfully";
	}
	
	// Remaining methods
}

//With Dependency Inversion Principle

class EmpController{
	
	//@Autowired
	private EmpService empService; //Here EmpController class dependents on EmpService(interface) but not on EmpServiceImpl class
	
	
	public String addEmployee(Employee employee) {
		empService.addEmployee(employee);
		return "Emp Added Successfully";
	}
	
	// Remaining methods
}

public class DependencyInversionPrinciple {
	//Definition: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
	//Benefit: Promotes loose coupling between high- and low-level components, making systems easier to maintain and extend.
	//Example: Instead of a class directly instantiating a dependency (e.g., a Database object), it should depend on an interface or abstract class (e.g., IDatabase), allowing for more flexibility in choosing the database implementation.
}
