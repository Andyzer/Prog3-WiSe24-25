import administration.Customer;

import java.io.Serializable;

public class CustomerImpl extends SuperCustomer implements Customer, Serializable {

    public CustomerImpl(String name) {
        this.name = name;
    }

    public CustomerImpl() {

    }
}
