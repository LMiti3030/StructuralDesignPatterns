package mititelu.laura;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    public List<Employee> getEmployeeList(){
        List<Employee> employees = new ArrayList<>();

        Employee employeeFromDB = new EmployeeDB("1234", "John", "Wick", "john@wick.com");

        employees.add(employeeFromDB);

        EmployeeLdap employeefromLdap = new EmployeeLdap("chewie", "Solo","Han", "han@solo.com");

        employees.add(new EmployeeAdapterLdap(employeefromLdap));

        EmployeeCSV emmployeeFromCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@holmes.com");

        employees.add(new EmployeeAdapterCSV(emmployeeFromCSV));

        return employees;
    }
}
