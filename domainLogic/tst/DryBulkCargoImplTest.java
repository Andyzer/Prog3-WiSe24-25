import administration.Customer;
import cargo.Hazard;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DryBulkCargoImplTest {

    @Test
    void testConstructorAndGetters() {
        Customer owner = mock(Customer.class);
        when(owner.getName()).thenReturn("Alice");

        BigDecimal value = BigDecimal.valueOf(5000);
        List<Hazard> hazards = List.of(Hazard.toxic, Hazard.flammable);
        int grainSize = 5;

        DryBulkCargoImpl cargo = new DryBulkCargoImpl(owner, value, hazards, grainSize);

        assertEquals(owner, cargo.getOwner());
        assertEquals(value, cargo.getValue());
        assertEquals(hazards, cargo.getHazards());
        assertEquals(grainSize, cargo.getGrainSize());
    }

    @Test
    void testSetAndGetStorageLocation() {
        DryBulkCargoImpl cargo = new DryBulkCargoImpl(
                mock(Customer.class),
                BigDecimal.valueOf(3000),
                List.of(Hazard.explosive),
                10
        );

        cargo.setStorageLocation(42);
        assertEquals(42, cargo.getStorageLocation());
    }

    @Test
    void testSetAndGetInsertionDate() {
        DryBulkCargoImpl cargo = new DryBulkCargoImpl(
                mock(Customer.class),
                BigDecimal.valueOf(3000),
                List.of(Hazard.radioactive),
                15
        );

        var now = new java.util.Date();
        cargo.setInsertionDate(now);
        assertEquals(now, cargo.getInsertionDate());
    }

    @Test
    void testSetAndGetLastInspectionDate() {
        DryBulkCargoImpl cargo = new DryBulkCargoImpl(
                mock(Customer.class),
                BigDecimal.valueOf(1500),
                List.of(Hazard.toxic),
                20
        );

        var lastInspectionDate = new java.util.Date();
        cargo.setLastInspectionDate(lastInspectionDate);
        assertEquals(lastInspectionDate, cargo.getLastInspectionDate());
    }

    @Test
    void testGetDurationOfStorage() throws InterruptedException {
        DryBulkCargoImpl cargo = new DryBulkCargoImpl(
                mock(Customer.class),
                BigDecimal.valueOf(1000),
                List.of(Hazard.flammable),
                25
        );

        cargo.setInsertionDate(new java.util.Date());
        Thread.sleep(10);
        assertNotNull(cargo.getDurationOfStorage());
        assertTrue(cargo.getDurationOfStorage().toMillis() > 0);
    }
}
