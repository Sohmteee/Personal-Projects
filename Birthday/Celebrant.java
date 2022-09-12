package Birthday;

public class Celebrant {
    int age;
    int birthday = 1;

    public Celebrant(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("Sohmtee is +1 today");
    }

    public int getAge() {
        return age;
    }
}
