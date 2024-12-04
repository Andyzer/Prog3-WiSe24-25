import administration.Customer;
import cargo.Hazard;
import cargo.UnitisedCargo;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class UnitisedCargoImpl implements UnitisedCargo, Stored {
    private final Customer owner;
    private final BigDecimal value;
    private final Collection<Hazard> hazards;
    private final boolean fragile;
    private Date insertionDate;
    private Date lastInspectionDate;
    private int storageLocation;

    public UnitisedCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, boolean fragile) {
        this.owner = owner;
        this.value = value;
        this.hazards = hazards;
        this.fragile = fragile;
    }

    @Override
    public Customer getOwner() {
        return owner;
    }

    @Override
    public Duration getDurationOfStorage() {
        return insertionDate == null ? null : Duration.between(insertionDate.toInstant(), new Date().toInstant());
    }

    @Override
    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    @Override
    public int getStorageLocation() {
        return storageLocation;
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
    public boolean isFragile() {
        return fragile;
    }

    @Override
    public void setStorageLocation(int storageLocation) {
        this.storageLocation = storageLocation;
    }

    @Override
    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    @Override
    public void setLastInspectionDate(Date lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }
}
