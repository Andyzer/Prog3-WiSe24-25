import administration.Storable;

import java.util.Date;

public interface Stored extends Storable {

    void setStorageLocation(int location);

    void setInsertionDate(Date date);

    void setLastInspectionDate(Date date);
}
