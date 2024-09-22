package entities;

import enums.ComponentType;

public class Material extends Component{
    private double unitPrice;
    private double quantity;
    private double transportPrice;
    private double qualityCoefficient;

    public Material(String name, ComponentType componentType, double vatRate, Project project, double unitPrice, double quantity, double transportPrice, double qualityCoefficient) {
        super(name, componentType, vatRate, project);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.transportPrice = transportPrice;
        this.qualityCoefficient = qualityCoefficient;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    public double getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }
}
