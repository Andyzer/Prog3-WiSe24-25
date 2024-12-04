import administration.Customer;

import java.io.Serializable;

public abstract class SuperCustomer implements Customer, Serializable {
    public String name;

    @Override
    public String getName() { return this.name; }

}
