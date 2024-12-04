import cargo.Cargo;

import java.util.Date;
import java.util.List;

public interface CargoImpl {

    boolean addCargo(Cargo cargo);

    boolean removeCargo(int location);

    boolean updateInspectionDate(int location, Date date);

    List<Cargo> listCargoByType(Class<?> type);

    List<String> listHazards(boolean include);


}
