class OrderPrijs {
    public void berekenTotaalPrijs() {
        System.out.println("bereken prijs");
    }
}
class OrderPrinter {
    public void printOrder() {
        System.out.println("print Order");
    }
}

class OrderOpslaan{
    public void slaOpInDatabase(){
        System.out.println("Opgeslagen in de database");
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Maak objecten van de klassen
        OrderPrijs orderPrijs = new OrderPrijs();
        OrderPrinter orderPrinter = new OrderPrinter();
        OrderOpslaan orderOpslaan = new OrderOpslaan();

        // Roep de methoden aan
        orderPrijs.berekenTotaalPrijs();
        orderPrinter.printOrder();
        orderOpslaan.slaOpInDatabase();
    }
}