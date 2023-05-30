package BasicClasses;

public class Employee extends Person {

    private int EmpId;
    private String Department;
    private String Room_No;
    private String Eligibility;

    Employee(){
    }
    public Employee(String name,String phone,int empid,String department,String roomno,String elig) {
        super(name,phone);
        this.EmpId = empid;
        this.Department = department;
        this.Room_No = roomno;
        this.Eligibility = elig;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int id) {
        this.EmpId = id;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String des) {
        this.Department = des;
    }

    public String getRoomNo() {
        return Room_No;
    }

    public void setRoomNo(String rno) {
        this.Room_No = rno;
    }

    public String getEligibility() {
        return Eligibility;
    }

    public void setEligibility(String elig) {
        this.Eligibility = elig;
    }
}
