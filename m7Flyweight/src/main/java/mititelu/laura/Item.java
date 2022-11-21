package mititelu.laura;

//Instances of Item will be Flyweights
//implementation of the Flyweight
//object that we're going to create a lot of
//everyting is final an immutable
//no setters
public class Item {

    private final String name;

    public Item(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
