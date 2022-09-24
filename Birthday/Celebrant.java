package Birthday;

import java.time.LocalDate;

public class Celebrant {
    int age;
    LocalDate birthday = LocalDate.of(2003, 10, 1);

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
