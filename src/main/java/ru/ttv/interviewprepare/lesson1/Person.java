package ru.ttv.interviewprepare.lesson1;

/**
 * @author Teplykh Timofey  25.08.2019
 */
public class Person {

    private String firstName;
    private String lastName;
    private String middlename;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person() {
    }

    public Person(String firstName, String lastName, String middlename, String country, String address, String phone, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middlename = middlename;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public static class Builder{

        private String firstName;
        private String lastName;
        private String middlename;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        public Person build(){
            return new Person(firstName, lastName, middlename, country, address, phone, age, gender);
        }

        public Builder addFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder addLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder addMiddleName(String middlename){
            this.middlename = middlename;
            return this;
        }

        public Builder addCountry(String country){
            this.country = country;
            return this;
        }

        public  Builder addAddres(String address){
            this.address = address;
            return this;
        }

        public Builder addPhone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder addAge(int age){
            this.age = age;
            return this;
        }

        public Builder addGender(String gender){
            this.gender = gender;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middlename='" + middlename + '\'' +
                ", country='" + country + '\'' +
                ", addres='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
