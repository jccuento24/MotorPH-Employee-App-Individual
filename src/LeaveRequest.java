/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
public class LeaveRequest {

    private int requestID;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String status;

    public LeaveRequest(int requestID,
            String leaveType,
            String startDate,
            String endDate) {

        this.requestID = requestID;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
    }

    public void submitRequest() {

        status = "Pending";
    
}
    public void approveRequest() {

        status = "Approved";
    }

    public void rejectRequest() {

        status = "Rejected";
    }

    public String getStatus() {
        return status;
    }
}
