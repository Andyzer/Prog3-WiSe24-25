import administration.Customer;
import cargo.DryBulkAndUnitisedCargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.Collection;

public class DryBulkAndUnitisedCargoImpl extends CargoSuper implements DryBulkAndUnitisedCargo {
    private final int grainSize;
    private final boolean fragile;

    public DryBulkAndUnitisedCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, int grainSize, boolean fragile) {
        super(owner, value, hazards);
        this.grainSize = grainSize;
        this.fragile = fragile;
    }

    @Override
    public int getGrainSize() {
        return grainSize;
    }

    @Override
    public boolean isFragile() {
        return fragile;
    }
}
