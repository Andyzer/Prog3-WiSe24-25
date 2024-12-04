import administration.Customer;
import cargo.Cargo;

import java.util.*;

public class StorageManagerImpl implements StorageManager {
    private final int capacity;
    private final Map<String, Customer> customers = new HashMap<>();
    private final Map<Integer, CargoSuper> storage = new HashMap<>();
    private int nextStorageLocation = 1;

    public StorageManagerImpl(int capacity) {
        this.capacity = capacity;
    }

    // Customer Handling

    @Override
    public synchronized boolean addCustomer(Customer customer) {
        if (customers.containsKey(customer.getName())) return false;
        customers.put(customer.getName(), customer);
        return true;
    }

    @Override
    public synchronized boolean removeCustomer(String name) {
        if (!customers.containsKey(name)) return false;

        storage.values().removeIf(cargo -> cargo.getOwner().getName().equals(name));
        customers.remove(name);
        return true;
    }

    @Override
    public synchronized List<String> listCustomers() {
        List<String> result = new ArrayList<>();
        customers.forEach((name, customer) -> {
            long cargoCount = storage.values().stream()
                    .filter(cargo -> cargo.getOwner().getName().equals(name))
                    .count();
            result.add(name + " (" + cargoCount + " items)");
        });
        return result;
    }

    // Cargo Handling

    @Override
    public synchronized boolean addCargo(CargoSuper cargo) {
        if (storage.size() >= capacity || !customers.containsKey(cargo.getOwner().getName())) {
            return false;
        }

        while (storage.containsKey(nextStorageLocation)) {
            nextStorageLocation++;
        }

        if (nextStorageLocation > capacity) return false;

        cargo.setStorageLocation(nextStorageLocation);
        cargo.setInsertionDate(new Date());
        storage.put(nextStorageLocation, cargo);

        return true;
    }

    @Override
    public synchronized boolean removeCargo(int location) {
        return storage.remove(location) != null;
    }

    @Override
    public boolean updateInspectionDate(int location, Date date) {
        CargoSuper cargo = storage.get(location);
        if (cargo == null) return false;
        cargo.setLastInspectionDate(date);
        return true;
    }

    @Override
    public synchronized List<Cargo> listCargoByType(Class<?> type) {
        List<Cargo> result = new ArrayList<>();
        for (Cargo cargo : storage.values()) {
            if (type.isInstance(cargo)) {
                result.add(cargo);
            }
        }
        return result;
    }

    @Override
    public synchronized List<String> listHazards(boolean include) {
        Set<String> hazards = new HashSet<>();
        storage.values().forEach(cargo -> {
            hazards.addAll(cargo.getHazards().stream().map(Enum::name).toList());
        });
        return include ? new ArrayList<>(hazards) : List.of();
    }
}
