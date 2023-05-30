package BasicClasses;

public class Print_Delivery extends User{
    private int Request_id;
    private String Document_name;
    private String Status;

    public Print_Delivery(int request_id,String document_name,String status) {
        super();
        this.Request_id = request_id;
        this.Document_name = document_name;
        this.Status = status;
    }

    public int getRequest_id() {
        return Request_id;
    }

    public void setRequest_id(int request_id) {
        Request_id = request_id;
    }

    public String getDocument_name() {
        return Document_name;
    }

    public void setDocument_name(String document_name) {
        Document_name = document_name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
