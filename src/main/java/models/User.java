package models;

public class User {
    String eMail;
    String password;
    String name;
    String lastName;

    public User setWitheMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    //==========================

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "User{" +
                "eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
