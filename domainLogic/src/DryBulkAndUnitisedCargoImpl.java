import administration.Customer;
import cargo.DryBulkAndUnitisedCargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DryBulkAndUnitisedCargoImpl implements DryBulkAndUnitisedCargo, Stored {
    private final Customer owner;
    private final BigDecimal value;
    private final Collection<Hazard> hazards;
    private final int grainSize;
    private final boolean fragile;
    private Date insertionDate;
    private Date lastInspectionDate;
    private int storageLocation;

    public DryBulkAndUnitisedCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, int grainSize, boolean fragile) {
        this.owner = owner;
        this.value = value;
        this.hazards = hazards;
        this.grainSize = grainSize;
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
    public int getGrainSize() {
        return grainSize;
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
