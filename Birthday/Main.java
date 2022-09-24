package Birthday;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Celebrant Sohmtee = new Celebrant(18);
        LocalDate today = LocalDate.now();

        boolean todayIsBirthday = (today.getDayOfMonth() == Sohmtee.birthday.getDayOfMonth())
                && (today.getMonth() == Sohmtee.birthday.getMonth());

        if (todayIsBirthday) {
            Sohmtee.setAge(Sohmtee.getAge() + 1);
        }

    }

}
