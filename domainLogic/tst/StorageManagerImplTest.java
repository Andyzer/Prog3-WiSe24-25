import administration.Customer;
import cargo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StorageManagerImplTest {

    private StorageManagerImpl storageManager;

    @BeforeEach
    void setUp() {
        storageManager = new StorageManagerImpl(5);
    }

    @Test
    void testAddCustomer() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");

        assertTrue(storageManager.addCustomer(customer));
        assertFalse(storageManager.addCustomer(customer));
    }

    @Test
    void testRemoveCustomer() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Bob");
        storageManager.addCustomer(customer);

        assertTrue(storageManager.removeCustomer("Bob"));
        assertFalse(storageManager.removeCustomer("Charlie"));
    }

    @Test
    void testListCustomers() {
        Customer alice = mock(Customer.class);
        when(alice.getName()).thenReturn("Alice");
        storageManager.addCustomer(alice);

        Customer bob = mock(Customer.class);
        when(bob.getName()).thenReturn("Bob");
        storageManager.addCustomer(bob);

        CargoSuper cargo = mock(CargoSuper.class);
        when(cargo.getOwner()).thenReturn(alice);
        storageManager.addCargo(cargo);

        List<String> customers = storageManager.listCustomers();
        assertTrue(customers.contains("Alice (1 items)"));
        assertTrue(customers.contains("Bob (0 items)"));
    }

    @Test
    void testAddCargo() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");
        storageManager.addCustomer(customer);

        CargoSuper cargo = mock(CargoSuper.class);
        when(cargo.getOwner()).thenReturn(customer);

        assertTrue(storageManager.addCargo(cargo));
        verify(cargo, times(1)).setStorageLocation(anyInt());
        verify(cargo, times(1)).setInsertionDate(any(Date.class));
    }

    @Test
    void testRemoveCargo() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");
        storageManager.addCustomer(customer);

        CargoSuper cargo = mock(CargoSuper.class);
        when(cargo.getOwner()).thenReturn(customer);
        storageManager.addCargo(cargo);

        assertTrue(storageManager.removeCargo(1));
        assertFalse(storageManager.removeCargo(2));
    }

    @Test
    void testUpdateInspectionDate() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");
        storageManager.addCustomer(customer);

        CargoSuper cargo = mock(CargoSuper.class);
        when(cargo.getOwner()).thenReturn(customer);
        storageManager.addCargo(cargo);

        Date newDate = new Date();
        assertTrue(storageManager.updateInspectionDate(1, newDate));
        verify(cargo, times(1)).setLastInspectionDate(newDate);
    }

    @Test
    void testListCargoByType() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");
        storageManager.addCustomer(customer);

        CargoSuper cargo1 = mock(CargoSuper.class);
        when(cargo1.getOwner()).thenReturn(customer);
        storageManager.addCargo(cargo1);

        CargoSuper cargo2 = mock(CargoSuper.class);
        when(cargo2.getOwner()).thenReturn(customer);
        storageManager.addCargo(cargo2);

        List<Cargo> cargos = storageManager.listCargoByType(CargoSuper.class);
        assertEquals(2, cargos.size());
    }

    @Test
    void testListHazards() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");
        storageManager.addCustomer(customer);

        CargoSuper cargo = mock(CargoSuper.class);
        when(cargo.getOwner()).thenReturn(customer);
        when(cargo.getHazards()).thenReturn(List.of(Hazard.flammable, Hazard.toxic));
        storageManager.addCargo(cargo);

        List<String> hazards = storageManager.listHazards(true);
        assertTrue(hazards.contains("flammable"));
        assertTrue(hazards.contains("toxic"));
    }

    @Test
    void testCapacityLimit() {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Alice");
        storageManager.addCustomer(customer);

        for (int i = 0; i < 5; i++) {
            CargoSuper cargo = mock(CargoSuper.class);
            when(cargo.getOwner()).thenReturn(customer);
            assertTrue(storageManager.addCargo(cargo));
        }

        CargoSuper extraCargo = mock(CargoSuper.class);
        when(extraCargo.getOwner()).thenReturn(customer);
        assertFalse(storageManager.addCargo(extraCargo));
    }
}
