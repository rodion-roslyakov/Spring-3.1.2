package springBoot.ProjectBoot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "FirstName must be not empty")
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "FName should be in this format: e.g. Rodion, Andrew")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "SecondName must be not empty")
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "SName should be in this format: Roslyakov")
    @Column(name = "second_name")
    private String secondName;
    @Positive(message = "Age must be positive")
    @Column(name = "age")
    private int age;

    public User() {

    }

    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surname='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
