package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


class Employees{
    String name;
    int salary;
    int experience;
    Employees(String name,int salary,int experience){
        this.name = name;
        this.salary=salary;
        this.experience=experience;
    }
}

public class FunctionPractise {
    public static void main(String[] args) {
        Function<Integer,Integer> function = n->n*n;
        System.out.println(function.apply(10));

        Employees employee = new Employees("Ranjith",50000,5);
        Employees employee1 = new Employees("Kirshva",60000,6);
        Employees employee2 = new Employees("John",40000,3);
        Employees employee3 = new Employees("Wick",45000,4);
        List<Employees> empLs = new ArrayList<>();
        empLs.add(employee);
        empLs.add(employee1);
        empLs.add(employee2);
        empLs.add(employee3);
        Predicate<Employees> predicate = emp -> emp.experience>3;
        Function<Employees,String> employeesFunction = empl-> {
            if(predicate.test(empl)){
                return "Employee "+empl.name+" is eligible for hike";
            }
            return "Employee "+empl.name+" is not eligible for hike";
        };
        for(Employees empl : empLs){
            System.out.println(employeesFunction.apply(empl));
        }

        //andThen and compose
        Function<Integer,Integer> square = n->n*n;
        Function<Integer,Integer> cubeOfSquare = n->n*n*n;
        System.out.println(square.andThen(cubeOfSquare).apply(2));
//        Function<Employees,Employees> getExp =

//        Function<Employees,Integer> empBonus = emp
    }
}
