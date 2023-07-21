public class Developer {
    private final String name;
    private final String surname;
    private final Integer age;
    private final Double salary;
    private final char gender;
    private final Car car;

    public Developer(String name, String surname, Integer age, Double salary, char gender, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public char getGender() {
        return gender;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", car=" + car +
                '}';
    }
}
