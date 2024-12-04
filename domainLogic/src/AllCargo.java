import administration.Customer;
import administration.Storable;
import cargo.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public abstract class AllCargo implements Cargo, Storable, Serializable , Customer,
        DryBulkCargo, LiquidBulkCargo, UnitisedCargo, DryBulkAndUnitisedCargo, LiquidAndDryBulkCargo,
        LiquidBulkAndUnitisedCargo {

    Customer owner;
    int storageLocation;
    BigDecimal value;
    Duration durationOfStorage;
    Date lastInspectionDate;
    Collection<Hazard> hazardsCollection;

    //optional Parameters, case by case
    int grainSize;
    boolean pressurized;
    boolean fragile;



    @Override
    public int getGrainSize() {
        return this.grainSize;
    }

    @Override
    public boolean isPressurized() {
        return this.pressurized;
    }

    @Override
    public boolean isFragile() {
        return this.fragile;
    }

    @Override
    public Customer getOwner() {
        return this.owner;
    }

    @Override
    public Duration getDurationOfStorage() {
        return this.durationOfStorage;
    }

    @Override
    public Date getLastInspectionDate() {
        return this.lastInspectionDate;
    }

    @Override
    public int getStorageLocation() {
        return this.storageLocation;
    }

    @Override
    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public Collection<Hazard> getHazards() {
        return this.hazardsCollection;
    }

}
