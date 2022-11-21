package mititelu.laura.withoutbrigde;

public class Shape1BridgeDemo {

    public static void main(String[] args) {

        Circle circle = new BlueCircle();

        Square square = new RedSquare();

        Square square1 = new GreenSquare();

        circle.applyColor();
        square.applyColor();
        square1.applyColor();

    }

}
