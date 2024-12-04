import administration.Customer;
import cargo.Hazard;
import cargo.UnitisedCargo;

import java.math.BigDecimal;
import java.util.Collection;

public class UnitisedCargoImpl extends CargoSuper implements UnitisedCargo {
    private final boolean fragile;

    public UnitisedCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, boolean fragile) {
        super(owner, value, hazards);
        this.fragile = fragile;
    }

    @Override
    public boolean isFragile() {
        return fragile;
    }
}
