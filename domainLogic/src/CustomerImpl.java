import administration.Customer;

import java.util.List;

public interface CustomerImpl {
    boolean addCustomer(Customer customer);

    boolean removeCustomer(String name);

    List<String> listCustomers();
}
