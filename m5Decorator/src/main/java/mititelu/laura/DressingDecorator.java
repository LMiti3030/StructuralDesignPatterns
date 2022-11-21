package mititelu.laura;

//using inheritance to extend the decorator
public class DressingDecorator extends SandwichDecorator{
    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make(){
        return customSandwich.make() + addDressing();
    }

    private String addDressing(){
        return " + mustard";
    }

}
