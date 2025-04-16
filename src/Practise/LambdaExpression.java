package Practise;

@FunctionalInterface
 interface Cab{
     void bookCab();
}

@FunctionalInterface
interface Cab1{
    void bookCabWithSourceandDestination(String source,String destination);
}

@FunctionalInterface
interface Cab2{
    String bookCabWithPrice(String source,String destination);
}

public class LambdaExpression {
    public static void main(String[] args) {
        Cab cab = ()-> System.out.println("Ola cab has been booked.");
        cab.bookCab();
        Cab1 cab1 = ((source, destination) -> System.out.println("Ola cab has been booked from "+source+" to "+destination));
        cab1.bookCabWithSourceandDestination("Salem","Bengaluru");
        Cab2 cab2 = (source,destination)->{
            System.out.println("Calculating amount between from "+source+" to "+destination);
            return "500";
        };
        String price = cab2.bookCabWithPrice("Salem","Bengaluru");
        System.out.println("Price amount is "+price);

    }

}
