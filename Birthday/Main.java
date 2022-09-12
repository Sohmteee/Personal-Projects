package Birthday;

public class Main {
    public static Celebrant Sohmtee = new Celebrant(18);
    public static Day Day = new Day();

    public static void main(String[] args) {

        if (Day.today == Sohmtee.birthday) {
            Sohmtee.setAge(Sohmtee.getAge() + 1);

            System.out.println(Sohmtee.getAge());
        }

    }

}
