package BasicClasses;

public class Print_Verification extends User {
    private int Request_id;
    private String Status;

    public Print_Verification(int request_id,String status) {
        super();
        this.Request_id = request_id;
        this.Status = status;
    }

    public int getRequest_id() {
        return Request_id;
    }

    public void setRequest_id(int request_id) {
        Request_id = request_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}