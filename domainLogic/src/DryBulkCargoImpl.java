import cargo.DryBulkCargo;
import administration.Customer;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.Collection;

public class DryBulkCargoImpl extends CargoSuper implements DryBulkCargo {
    private final int grainSize;

    public DryBulkCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, int grainSize) {
        super(owner, value, hazards);
        this.grainSize = grainSize;
    }

    @Override
    public int getGrainSize() {
        return grainSize;
    }
}
