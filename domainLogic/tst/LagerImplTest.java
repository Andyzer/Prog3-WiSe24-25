import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LagerImplTest {

    private LagerImpl lager;

    @BeforeEach
    void setUp() {
        Lager lager = new LagerImpl(BigDecimal.valueOf(10000));
    }

    @Test
    public void testAddCostumerSuccess() {
        // Erfolgreich einen Produzenten hinzufügen
        assertTrue(lager.addCostumer("Costumer"), "Producer sollte erfolgreich hinzugefügt werden");
    }

    @Test
    public void addCostumerNameAlreadyExistent() {
        lager.addCostumer("Costumer");
        lager.addCostumer("Costumer");
        assertTrue(lager.addCostumer("Costumer"));

    }

    @Test
    public void addCostumerEmptyName(){
        lager.addCostumer("");
    }

}