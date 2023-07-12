public class PersonBuilder implements Builder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Некорректный возраст.");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (this.name != null || this.surname != null) {
            if (this.age == 0) {
                person = new Person(this.name, this.surname);
            } else {
                person = new Person(this.name, this.surname, this.age);
            }
        } else {
            throw new IllegalStateException("Не заполнены обязательные поля Имя и/или Фамилия.");
        }
        person.setAddress(this.address);
        return person;
    }
}
