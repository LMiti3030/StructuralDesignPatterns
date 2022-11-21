package mititelu.laura;

//Order is going to consume items
//nothing to do with the pattern

public class Order {

    private final int orderNumber;
    private final Item item;

    Order(int orderNumber, Item item){
        this.item = item;
        this.orderNumber = orderNumber;
    }

    void processOrder(){
        System.out.println("Ordering " + item + " for order number "+ orderNumber);
    }

}
