import administration.Customer;
import cargo.Hazard;
import cargo.LiquidBulkCargo;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class LiquidBulkCargoImpl implements LiquidBulkCargo, Stored {
    private final Customer owner;
    private final BigDecimal value;
    private final Collection<Hazard> hazards;
    private final boolean pressurized;
    private Date insertionDate;
    private Date lastInspectionDate;
    private int storageLocation;

    public LiquidBulkCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, boolean pressurized) {
        this.owner = owner;
        this.value = value;
        this.hazards = hazards;
        this.pressurized = pressurized;
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
    public boolean isPressurized() {
        return pressurized;
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
