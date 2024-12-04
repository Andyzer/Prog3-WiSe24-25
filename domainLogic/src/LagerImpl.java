import cargo.Cargo;
import cargo.Hazard;

import java.math.BigDecimal;
import java.util.*;

public class LagerImpl implements Lager {

    private LinkedList<AllCargo> cargoList = new LinkedList<>();
    private BigDecimal maxSizeOfMemory = BigDecimal.valueOf(0);
    private BigDecimal totalSize = BigDecimal.valueOf(0);
    private LinkedList<SuperCustomer> customerList = new LinkedList<>();
    private Map<Hazard, Integer> hazardMap = new HashMap<>();

    //  private transient List<Observer> observerList;

    public LagerImpl(BigDecimal capacity) {
        System.out.println("LagerImpl created with capacity: " + capacity);
        BigDecimal minCapacity = new BigDecimal(0);
        if (capacity.compareTo(minCapacity) >= 0) {
            this.maxSizeOfMemory = capacity;
        }
    }

    ///////////////////////////////////////////////
    ////////////  COSTUMER METHODS  ///////////////
    ///////////////////////////////////////////////

    @Override
    public synchronized boolean addCostumer(String name) {
        if (checkIfCostumerIsListed(name)){
            return false;
        }

        SuperCustomer newCustomer = new CustomerImpl();
        customerList.add(newCustomer);

        System.out.println("Current producer list after addition:"); //debug
        for (SuperCustomer customer : customerList) {
            System.out.println("New Customer created: " + newCustomer );
        }

        return true;
    }

    @Override
    public LinkedList<SuperCustomer> getCustomerList() {
        System.out.println("Fetching CustomerList: " + customerList.size()); //debug
        return new LinkedList<>(this.customerList);
    }

    @Override
    public LinkedList<SuperCustomer> getSuperCostumer() {
        return new LinkedList<>(this.customerList);
    }

    @Override
    public boolean deleteCostumer(String name) {
        return false;
    }

    @Override
    public boolean checkIfCostumerIsListed(String name) {
        return false;
    }

    @Override
    public boolean checkIfNameIsEmpty(String name) {
        return false;
    }

    @Override
    public int getIndexOfCostumer(String name) {
        return 0;
    }

    ///////////////////////////////////////////////
    //////////////  ADMIN METHODS  ////////////////
    ///////////////////////////////////////////////

    @Override
    public boolean addCargo(String cargoType, String customerName) {
        return false;
    }

    @Override
    public boolean deleteCargo(Cargo cargo) {
        return false;
    }

    @Override
    public boolean updateCargo(int loc, Date date) {
        return false;
    }

    @Override
    public LinkedList<AllCargo> getCargoList() {
        return null;
    }

    @Override
    public LinkedList<Hazard> getUsedHazards() {
        return null;
    }

    @Override
    public LinkedList<Hazard> getUnusedHazards() {
        return null;
    }
}
