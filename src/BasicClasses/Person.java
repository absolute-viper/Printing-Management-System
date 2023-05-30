package BasicClasses;

public class Person {
    private String Name;
    private String Phone_No;

    Person(){

    }
    public Person(String name,String phoneno) {
        this.Name = name;
        this.Phone_No = phoneno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPhoneNo() {
        return Phone_No;
    }

    public void setPhoneNo(String phone) {
        this.Phone_No = phone;
    }
}

