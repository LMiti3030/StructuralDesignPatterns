package mititelu.laura;

//decorators should be treated as objects
public abstract class SandwichDecorator implements Sandwich {

    protected Sandwich customSandwich;

    //can receive an instance of another decorator
    public SandwichDecorator(Sandwich customSandwich){
        this.customSandwich = customSandwich;
    }

    public String make(){
        return customSandwich.make();
    }

}
