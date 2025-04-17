package LambdaExpressions;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

  class Employee{
      String name;
      int salary;
      int experience;
      Employee(String name,int salary,int experience){
          this.name = name;
          this.salary=salary;
          this.experience=experience;
      }
}

public class PredicatePractise {



    public static void main(String[] args) {
        //case 1
        Predicate<Integer> predicate = i-> (i>10);
        System.out.println(predicate.test(90));

        //case 2
        Predicate<String> pred = i->(i.length()>10);
        System.out.println(pred.test("Ranjith"));

        //case 3
        Predicate<String[]> predArr = i->{
            for(String str : i){
                if(str.length()<5){
                    return false;
                }
            }
            return true;
        };
        String[] strArr = {"Array","12345","qwerty"};
        System.out.println(predArr.test(strArr));

        //case 3
        Employee employee = new Employee("Ranjith",50000,5);
        Employee employee1 = new Employee("Kirshva",60000,6);
        Employee employee2 = new Employee("John",40000,3);
        Employee employee3 = new Employee("Wick",45000,4);
        List<Employee> empLs = new ArrayList<>();
        empLs.add(employee);
        empLs.add(employee1);
        empLs.add(employee2);
        empLs.add(employee3);
        Predicate<Employee> employeePredicate = emp -> (emp.experience>=5 && emp.salary>=50000);
        for(Employee emp : empLs){
            if(employeePredicate.test(emp)){
                System.out.println(emp.name);
            }
        }
        //case 4

        int[] arr = {3,4,5,7,9,11,20,23,25,27,30,31,33,35,40,45,47,49,50,55,57,60,65,68,69,70,73,75,77,79,86,88,93,96,97,99,100};
        Predicate<Integer> evenrPredicate = i->i%2==0;
        Predicate<Integer> greaterPredicate = i->i>45;

        for(int i:arr){
            if(evenrPredicate.and(greaterPredicate).test(i)){
                System.out.println("Even number which are greater than 45 : "+i);
            }
        }
        for(int i:arr){
            if(evenrPredicate.or(greaterPredicate).test(i)){
                System.out.println("Number which are greater than 45 or Even : "+i);
            }
        }
        for(int i:arr){
            if((greaterPredicate).negate().test(i)){
                System.out.println("Number which are not greater than 45 and Even : "+i);
            }
        }
    }
}
