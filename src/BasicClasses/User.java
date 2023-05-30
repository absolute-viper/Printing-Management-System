package BasicClasses;

public class User extends Employee{
    private String username;
    private String password;
    private int empid;

    public User(){
    }
    public User(String username,String password,int id) {
        super();
        this.username = username;
        this.password = password;
        this.empid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }
}
