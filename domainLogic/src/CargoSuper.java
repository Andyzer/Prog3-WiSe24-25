import administration.Customer;
import administration.Storable;
import cargo.Cargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public abstract class CargoSuper implements Cargo, Storable {
    private final Customer owner;
    private final BigDecimal value;
    private final Collection<Hazard> hazards;
    private Date insertionDate;
    private Date lastInspectionDate;
    private int storageLocation;

    public CargoSuper(Customer owner, BigDecimal value, Collection<Hazard> hazards) {
        this.owner = owner;
        this.value = value;
        this.hazards = hazards;
    }

    @Override
    public Customer getOwner() {
        return owner;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public Collection<Hazard> getHazards() {
        return hazards;
    }

    @Override
    public int getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(int storageLocation) {
        this.storageLocation = storageLocation;
    }

    @Override
    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(Date lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    @Override
    public Duration getDurationOfStorage() {
        return insertionDate == null ? null : Duration.between(insertionDate.toInstant(), new Date().toInstant());
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }
}
