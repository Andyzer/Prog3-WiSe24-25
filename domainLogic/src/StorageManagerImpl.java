import administration.Customer;
import administration.Storable;
import cargo.Cargo;

import java.util.*;

public class StorageManagerImpl implements StorageManager {

    private final int capacity;
    private final Map<String, Customer> customers = new HashMap<>();
    private final Map<Integer, Cargo> storage = new HashMap<>();
    private int nextStorageLocation = 1;

    public StorageManagerImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customers.containsKey(customer.getName())) return false;
        customers.put(customer.getName(), customer);
        return true;
    }

    @Override
    public boolean removeCustomer(String name) {
        if (!customers.containsKey(name)) return false;

        storage.values().removeIf(cargo -> ((Storable) cargo).getOwner().getName().equals(name));
        customers.remove(name);
        return true;
    }

    @Override
    public List<String> listCustomers() {
        List<String> result = new ArrayList<>();
        customers.forEach((name, customer) -> {
            long cargoCount = storage.values().stream()
                    .filter(cargo -> ((Storable) cargo).getOwner().getName().equals(name))
                    .count();
            result.add(name + " (" + cargoCount + " items)");
        });
        return result;
    }

    @Override
    public boolean addCargo(Cargo cargo) {
        if (!(cargo instanceof Stored storable)) return false;

        if (storage.size() >= capacity || !customers.containsKey(storable.getOwner().getName())) {
            return false;
        }

        while (storage.containsKey(nextStorageLocation)) {
            nextStorageLocation++;
        }

        if (nextStorageLocation > capacity) return false;

        storable.setStorageLocation(nextStorageLocation);
        storable.setInsertionDate(new Date());
        storage.put(nextStorageLocation, cargo);

        return true;
    }


    @Override
    public boolean removeCargo(int location) {
        return storage.remove(location) != null;
    }

    @Override
    public boolean updateInspectionDate(int location, Date date) {
        Cargo cargo = storage.get(location);
        if (!(cargo instanceof Stored stored)) return false;
        stored.setLastInspectionDate(date);
        return true;
    }

    @Override
    public List<Cargo> listCargoByType(Class<?> type) {
        List<Cargo> result = new ArrayList<>();
        for (Cargo cargo : storage.values()) {
            if (type.isInstance(cargo)) {
                result.add(cargo);
            }
        }
        return result;
    }

    @Override
    public List<String> listHazards(boolean include) {
        Set<String> hazards = new HashSet<>();
        storage.values().forEach(cargo -> {
            hazards.addAll(((Cargo) cargo).getHazards().stream().map(Enum::name).toList());
        });
        return include ? new ArrayList<>(hazards) : List.of();
    }
}
