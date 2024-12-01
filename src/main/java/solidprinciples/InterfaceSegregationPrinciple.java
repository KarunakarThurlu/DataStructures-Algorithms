package solidprinciples;

//Without Interface Segregation Principle
interface Worker {
    void work();
    void eat();
}

class Developer implements Worker {
    public void work() {
        System.out.println("Coding...");
    }

    public void eat() {
        System.out.println("Eating...");
    }
}

class Robot implements Worker {
    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat!");
    }
}

//With Interface Segregation Principle
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class DeveloperImpl implements Workable, Eatable {
    public void work() {
        System.out.println("Coding...");
    }

    public void eat() {
        System.out.println("Eating...");
    }
}

class RobotImpl implements Workable {
    public void work() {
        System.out.println("Working...");
    }
}

public class InterfaceSegregationPrinciple {
	//Definition: Clients should not be forced to depend on interfaces they do not use.
	//Benefit: This keeps interfaces small and focused, ensuring that implementing classes are not burdened with unnecessary methods.
	//Example: Instead of a large interface that includes methods for both printing and scanning (for a multi-functional device), create separate interfaces like Printer and Scanner that can be implemented independently.
}
