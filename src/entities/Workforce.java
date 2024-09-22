package entities;

import enums.ComponentType;
import enums.WorkforceLevel;

public class Workforce extends Component{
    private WorkforceLevel workforceLevel;
    private double hourlyRate;
    private double workHours;
    private double productivityCoefficient;

    public Workforce(String name, ComponentType componentType, double vatRate, Project project, WorkforceLevel workforceLevel, double hourlyRate, double workHours, double productivityCoefficient) {
        super(name, componentType, vatRate, project);
        this.workforceLevel = workforceLevel;
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
        this.productivityCoefficient = productivityCoefficient;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public ComponentType getComponentType() {
        return super.getComponentType();
    }

    @Override
    public void setComponentType(ComponentType componentType) {
        super.setComponentType(componentType);
    }

    @Override
    public double getVatRate() {
        return super.getVatRate();
    }

    @Override
    public void setVatRate(double vatRate) {
        super.setVatRate(vatRate);
    }

    public WorkforceLevel getWorkforceLevel() {
        return workforceLevel;
    }

    public void setWorkforceLevel(WorkforceLevel workforceLevel) {
        this.workforceLevel = workforceLevel;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public double getProductivityCoefficient() {
        return productivityCoefficient;
    }

    public void setProductivityCoefficient(double productivityCoefficient) {
        this.productivityCoefficient = productivityCoefficient;
    }
}
