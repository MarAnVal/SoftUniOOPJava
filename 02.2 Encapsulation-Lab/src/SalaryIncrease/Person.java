package SalaryIncrease;

import java.text.DecimalFormat;

class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        bonus = bonus / 100;
        if(this.age < 30){
            bonus /= 2;
        }
        this.salary += this.salary *bonus;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0#####");

        return String.format("%s %s gets %s leva",
        this.firstName, this.lastName, df.format(this.salary));
    }
}

