
package com.example.peoples;

        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;


@Service
public class EmployeeService1 implements EmployeeService{
    int value = 10;

    private final List<Employee> people = new ArrayList<>(List.of(new Employee("ee","dd"),new Employee("ff","bb")));



    @Override
    public  Employee add(String name,String lastname)throws EmployeeStorageIsFullException,EmployeeAlreadyAddedException{
        Employee a = new Employee(name,lastname);
        if (people.size()>=value){
            throw new EmployeeStorageIsFullException();

        }
        if (people.contains(a)){
            throw new EmployeeAlreadyAddedException();
        }
        people.add(a);
        return a;
    }
    @Override
    public  Employee remove(String name,String lastname)throws EmployeeNotFoundException{
        Employee a = new Employee(name,lastname);
        if (people.contains(a)){
            people.remove(a);
            return a;

        }
        throw new EmployeeNotFoundException();

    }
    @Override
    public  Employee search(String name,String lastname)throws EmployeeNotFoundException{
        Employee a = new Employee(name,lastname);
        if (!people.contains(a)){
            throw new EmployeeNotFoundException();
        }
        return a;

    }
    @Override
    public Object[] list(){
        return people.toArray();
    }




}

