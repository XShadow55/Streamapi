
package com.example.StreamAPI;

        import org.springframework.stereotype.Service;

        import javax.swing.text.html.Option;
        import java.util.*;
        import java.util.stream.Stream;



@Service
public class EmployeeService1 implements EmployeeService{


     final List<Employee> people =  new ArrayList<>(List.of(
             new Employee("Иван","Иванов",1,10000),
             new Employee("Петя","Попов",1,10300),
            new Employee("Максим","Бугров",2,14000)));




    @Override
    public  String  add(String name,String lastname,Integer dep,Integer salary){
        Employee a = new Employee(name,lastname,dep,salary);


        people.add(a);
        return a.toString1();
    }
    @Override
    public  String  remove(String name,String lastname,Integer dep,Integer salary) {
        Employee a = new Employee(name, lastname, dep, salary);
        if (people.contains(a)) {
            people.remove(a);
            return a.toString1();
        }
        return a.toString1();
    }
    @Override
    public  String  search (String name, String lastname,Integer dep,Integer salary){
        Employee a = new Employee(name,lastname, dep, salary);
        if (!people.contains(a)){

        }
        return a.toString1();

    }
    @Override
    public Object[] list(){
        List<String> rr = new ArrayList<>();
        people.forEach((Employee people) -> rr.add(people.toString()));
        return rr.toArray();
    }

    @Override
    public String max(Integer dep) {
        Map<String ,Integer> pp = new HashMap<>();
        people.stream().filter((people -> people.getDepartment() == dep)).forEach((Employee emploe) -> pp.put(emploe.toString1(),emploe.getSalary()));

}

