package BasicClasses;

public class Print_Request extends Print_Details{

    private int RequestId;
    private int EmpId;
    private String FileId;
    private String TaskType;


    public Print_Request(int reqid,int empId, String fileid,String taskType,String papersize,String color, String sides,
                         int Copies, String orientation) {
        super(papersize, color, sides, Copies, orientation);
        this.RequestId = reqid;
        this.EmpId = empId;
        this.FileId = fileid;
        this.TaskType = taskType;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int reqid) {
        this.RequestId = reqid;
    }

    public String getFileId() {
        return FileId;
    }

    public void setFileId(String fileid) {
        this.FileId = fileid;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public String getTaskType() {
        return TaskType;
    }

    public void setTaskType(String taskType) {
        TaskType = taskType;
    }
}