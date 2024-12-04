import administration.Customer;
import cargo.Hazard;
import cargo.LiquidBulkAndUnitisedCargo;

import java.math.BigDecimal;
import java.util.Collection;

public class LiquidBulkAndUnitisedCargoImpl extends CargoSuper implements LiquidBulkAndUnitisedCargo {
    private final boolean pressurized;
    private final boolean fragile;

    public LiquidBulkAndUnitisedCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, boolean pressurized, boolean fragile) {
        super(owner, value, hazards);
        this.pressurized = pressurized;
        this.fragile = fragile;
    }

    @Override
    public boolean isPressurized() {
        return pressurized;
    }

    @Override
    public boolean isFragile() {
        return fragile;
    }
}
