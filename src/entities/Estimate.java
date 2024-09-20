package entities;

import java.util.Date;

public class Estimate {
    private int id;
    private double amount;
    private Date issueDate;
    private Date validateDate;
    private boolean accepted = false;
    private Project project;

    public Estimate(double amount, Date issueDate, Date validateDate, Project project) {
        this.amount = amount;
        this.issueDate = issueDate;
        this.validateDate = validateDate;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}
