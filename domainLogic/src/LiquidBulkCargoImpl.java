import cargo.LiquidBulkCargo;
import administration.Customer;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.Collection;

public class LiquidBulkCargoImpl extends CargoSuper implements LiquidBulkCargo {
    private final boolean pressurized;

    public LiquidBulkCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, boolean pressurized) {
        super(owner, value, hazards);
        this.pressurized = pressurized;
    }

    @Override
    public boolean isPressurized() {
        return pressurized;
    }
}
