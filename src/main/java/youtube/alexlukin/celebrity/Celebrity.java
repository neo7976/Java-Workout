package youtube.alexlukin.celebrity;


/**
 * Требуется найти знаменитость.
 * Знаменитость - его знают все остальные люди в исходном списке, но сама знаменитость не знает никого из этого списка.
 */

public class Celebrity {
    public static Person findCelebrity(Person[] person) {
        int l = 0, r = person.length - 1;
        while (l != r) {
            if (person[l].knows(person[r]))
                l++;
            else
                r--;
        }
        for (int i = 0; i < person.length; i++) {
            if (i != l && (!person[i].knows(person[l]) || person[l].knows(person[i])))
                return null;
        }
        return person[l];
    }


    public static void main(String[] args) {
        Person mom = new Person("Татьяна", "Иванова");
        Person pap = new Person("Иван", "Иванов");
        Person alex = new Person("Алексей", "Петров");
        Person celebrity = new Person("Брэд", "Питт");

        Person ivan = new Person.PersonBuilder()
                .setName("Ivan")
                .setSurname("Fedorov")
                .setFamiliarity(pap, celebrity)
                .build();
        System.out.println(ivan);

        System.out.printf("До удаления %s знал следующих людей: %s\n", ivan.getName(), ivan.getFamiliarity());
        ivan.getFamiliarity().remove(pap);
        System.out.printf("После удаления %s знает следующих людей: %s\n", ivan.getName(), ivan.getFamiliarity());


        mom.setFamiliarity(pap, alex, celebrity);
        pap.setFamiliarity(mom, celebrity);
        alex.setFamiliarity(mom, celebrity);

        Person[] persons = new Person[]{
                mom,
                pap,
                alex,
                ivan,
                celebrity
        };
        System.out.println("Наша звезда: " + findCelebrity(persons));
    }
}
