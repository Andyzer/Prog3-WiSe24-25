import administration.Customer;
import cargo.Hazard;
import cargo.LiquidAndDryBulkCargo;

import java.math.BigDecimal;
import java.util.Collection;

public class LiquidAndDryBulkCargoImpl extends CargoSuper implements LiquidAndDryBulkCargo {
    private final boolean pressurized;
    private final int grainSize;

    public LiquidAndDryBulkCargoImpl(Customer owner, BigDecimal value, Collection<Hazard> hazards, boolean pressurized, int grainSize) {
        super(owner, value, hazards);
        this.pressurized = pressurized;
        this.grainSize = grainSize;
    }

    @Override
    public boolean isPressurized() {
        return pressurized;
    }

    @Override
    public int getGrainSize() {
        return grainSize;
    }
}
