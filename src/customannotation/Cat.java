package customannotation;

@VeryImportant
public class Cat {

    @ImportString
    String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    @VeryImportant
    public void meow() {
        System.out.println("meow");
    }

    @RunImmediately(times = 3)
    public void eat() {
        System.out.println("eating");
    }

}
