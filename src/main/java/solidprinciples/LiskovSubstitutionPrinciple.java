package solidprinciples;


//Without Liskov Substitution Principle
interface FlyingBirdImpl {
    void fly();
}

class PenguinBird implements FlyingBirdImpl {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

//With Liskov Substitution Principle
interface Bird {
    void eat();
}

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() {
        System.out.println("Flying...");
    }

    public void eat() {
        System.out.println("Eating...");
    }
}

class Penguin implements Bird {
    public void eat() {
        System.out.println("Eating...");
    }
}


public class LiskovSubstitutionPrinciple {
	//Definition: Objects of a superclass should be replaceable with objects of its subclasses without affecting the functionality of the program.
	//Benefit: Ensures that a subclass can be substituted for its parent class without introducing errors or unexpected behavior.
	//Example: If a class Bird has a method fly(), a subclass Penguin should not override it with a method that throws an error, as penguins can't fly. This would violate LSP.
}
