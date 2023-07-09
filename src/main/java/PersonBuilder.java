public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public String address;

    public PersonBuilder() {
        super();
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurName(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        if (age < 0 || age >= 100) {
            throw new IllegalArgumentException("Недопустимый возраст");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }
        return new Person(this);
    }
}
