package Week5.InheritanceAndPolymorphism.Practice;

public class Pie {
    public static void main(String[] args){

        Human h = new Human();
        System.out.println(h.toString());
        System.out.println(h);

        Human h2 = new Male();
        System.out.println(((Male) h2).show());

        Human h3 = new Female();
        System.out.println(h);
    }

    public static void doSomething(Human h) {
        System.out.println(h.whoAmI());
    }
}

class Human{

    // @Override
    public String toString() {
        return "Human";
    }
    public String whoAmI() {
        return "Human";
    }

}

class Male extends Human{
    
    @Override
    public String toString() {
        return "Male";
    }

    @Override
    public String whoAmI() {
        return "Male";
    }

    public String show() {
        return "I am a man";
    }
}

class Female extends Human {

    @Override 
    public String toString() {
        return "Female";
    }
    
    @Override
    public String whoAmI() {
        return "Female";
    }
}

class Boy extends Male {
    
    // @Override
    // public String toString() {
    //     return "Boy";
    // }
}

class Man extends Male {
    
    @Override 
    public String toString() {
        return "Man";
    }
}

class Girl extends Female {
    @Override
    public String toString() {
        return "Girl";
    }
}

class Woman  extends Female {
    @Override
    public String toString() {
        return "Woman";
    }
}