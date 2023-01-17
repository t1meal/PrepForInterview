package ru.gb.models;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getCountry() {
        return country;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
        country = builder.country;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
        gender = builder.gender;
    }

    public Person() {
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        public Builder firstName (String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName (String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder middleName (String middleName) {
            this.middleName = middleName;
            return this;
        }
        public Builder country (String country) {
            this.country = country;
            return this;
        }
        public Builder address (String address) {
            this.address = address;
            return this;
        }
        public Builder phone (String phone) {
            this.phone = phone;
            return this;
        }
        public Builder age (int age) {
            this.age = age;
            return this;
        }
        public Builder gender (String gender) {
            this.gender = gender;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
}
