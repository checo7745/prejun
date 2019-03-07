package model;

public class TransportPlane extends Plane {

    private Consignment consignment;
    private double carryingCapacity;

    public TransportPlane() {
        super();
    }

    public TransportPlane(Consignment consignment, double carryingCapacity, double distance) {
        this.consignment = consignment;
        this.carryingCapacity = carryingCapacity;
        setDistanceCapacity(distance);
    }

    public Consignment getConsignment() {
        return consignment;
    }

    public void setConsignment(Consignment consignment) {
        this.consignment = consignment;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportPlane)) return false;
        if (!super.equals(o)) return false;

        TransportPlane that = (TransportPlane) o;

        return consignment == that.consignment;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (consignment != null ? consignment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransportPlane{" +
                "consignment=" + consignment +
                '}';
    }
}
