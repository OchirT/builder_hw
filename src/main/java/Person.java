import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;

    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurName(getSurName()).setAge(age - 18).setAddress(getAddress());
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(age);
    }

    public String getAddress() {
        if (hasAddress()) {
            return address;
        }
        return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = age + 1;
        }
    }

    @Override
    public String toString() {
        return name + " " +
                surname + ", " + age +
                " лет, " + "проживающий по адресу: " + address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

}
