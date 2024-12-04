import administration.Customer;
import cargo.Cargo;

import java.util.Date;
import java.util.List;

public interface StorageManager {
    // Customer Handling
    boolean addCustomer(Customer customer);

    boolean removeCustomer(String name);

    List<String> listCustomers();

    // Cargo Handling
    boolean addCargo(CargoSuper cargo);

    boolean removeCargo(int location);

    boolean updateInspectionDate(int location, Date date);

    List<Cargo> listCargoByType(Class<?> type);

    List<String> listHazards(boolean include);
}
