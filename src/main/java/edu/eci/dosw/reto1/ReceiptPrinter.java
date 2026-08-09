package edu.eci.dosw.reto1;
import java.util.stream.*;


public class ReceiptPrinter {

    private ReceiptPrinter(){
    }

    public static void print(Bill bill, Customer customer){
        String list = bill.getProducts().stream()
            .collect(Collectors.groupingBy(Product::getName))
            .entrySet().stream()
            .map(s -> String.format("%s x%d -> $%,.0f", s.getKey(), s.getValue().size(),
                    s.getValue().stream().mapToDouble(Product::getPrice).sum()))
            .collect(Collectors.joining("\n"));

         System.out.println("Cliente: " + customer.getTypeName());
         System.out.println(list);
         System.out.println();
         System.out.printf("Subtotal: $%,d%n", bill.getSubtotal());
         System.out.printf("Descuento: $%,.0f%n", bill.getDiscountAmount());
         System.out.printf("Total: $%,.0f%n", bill.getTotal());
         System.out.println("¡Gracias por su compra!");

    }


}
