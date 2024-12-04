import cargo.Cargo;
import cargo.Hazard;

import java.util.Date;
import java.util.LinkedList;

public interface Lager {


    ///////////////////////////////////////////////
    ////////////  COSTUMER METHODS  ///////////////
    ///////////////////////////////////////////////

    /**
     * add new costumer to costumerList
     * @param name of costumer
     * @return true if adderd, false if failed or name already in list
     */
    boolean addCostumer(String name);

    /**
     * get list of all Costumers as return
     * @return LinkedList of all Costumers so far
     */
    LinkedList<SuperCustomer> getCustomerList();

    /**
     * get list of all SuperCostumers
     * @return LinkedList of all SuperCostumers
     */
    LinkedList<SuperCustomer> getSuperCostumer();

    /**
     * method to delete certain costumer
     * @param name of costumer to be deleted
     * @return true if deleted, false if couldnt be deleted
     */
    boolean deleteCostumer(String name);

    /**
     * check if costumer is already listed
     * @param name of costumer to check
     * @return true if in list, false if not in list
     */
    boolean checkIfCostumerIsListed(String name);


    /**
     * check if customer name is empty
     * @param name shouldn't be empty
     * @return true if empty, false if not
     */
    boolean checkIfNameIsEmpty(String name);

    /**
     * get index of costumer in producerList
     * @param name of costumer to search
     * @return index of costumer, -1 if not in list
     */
    int getIndexOfCostumer(String name);

    ///////////////////////////////////////////////
    //////////////  ADMIN METHODS  ////////////////
    ///////////////////////////////////////////////

    boolean addCargo(String cargoType, String customerName);

    boolean deleteCargo(Cargo cargo);

    boolean updateCargo(int loc, Date date);

    LinkedList<AllCargo> getCargoList();

    LinkedList<Hazard> getUsedHazards();

    LinkedList<Hazard> getUnusedHazards();

}
