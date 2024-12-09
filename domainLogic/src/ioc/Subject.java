package ioc;

import java.math.BigDecimal;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void aktualisiere();

    BigDecimal getTotalSize();

    BigDecimal getMaxSizeOfMemory();
}
