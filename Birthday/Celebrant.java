package Birthday;

public class Celebrant {
    int age;
    int birthday = 1;

    public Celebrant(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("\nSohmtee++ today\n");
    }

    public int getAge() {
        return age;
    }
}
