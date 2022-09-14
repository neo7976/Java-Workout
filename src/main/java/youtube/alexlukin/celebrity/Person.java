package youtube.alexlukin.celebrity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private String name;
    private String surname;
    private List<Person> familiarity = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.familiarity = personBuilder.familiarity;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public boolean knows(Person person) {
        return getFamiliarity().contains(person);
    }

    public List<Person> getFamiliarity() {
        return familiarity;
    }

    public void setFamiliarity(Person... persons) {
        this.familiarity.addAll(Arrays.asList(persons));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static class PersonBuilder {
        private String name;
        private String surname;
        private List<Person> familiarity = new ArrayList<>();

        public PersonBuilder() {
            super();
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setFamiliarity(Person... people) {
            this.familiarity.addAll(Arrays.asList(people));
            return this;
        }

        public Person build() {
            Person person = null;
            if ((this.name == null || this.name.trim().isEmpty()) && (this.surname == null || this.surname.trim().isEmpty()))
                throw new IllegalStateException("Не хватает данных для создания класса");
            else
                person = new Person(this);
            return person;
        }

    }
}
