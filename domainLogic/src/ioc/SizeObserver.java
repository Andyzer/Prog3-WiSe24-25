package ioc;

import eventLogic.CargoEvent;

import java.io.PrintStream;
import java.math.BigDecimal;

public class SizeObserver implements Observer {

    private final Subject subject;
    private BigDecimal lastSize;
    private BigDecimal maximumSize;
    private PrintStream printStream;


    public SizeObserver(PrintStream printStream, Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
        this.lastSize = subject.getTotalSize();
        this.maximumSize = this.subject.getMaxSizeOfMemory();
        this.printStream = printStream;
    }

    @Override
    public void aktualisiere() {
        BigDecimal newSize = subject.getTotalSize();
        if (this.lastSize.equals(newSize)) return;
        this.lastSize = newSize;
        double ninetyPercent = maximumSize.doubleValue() * 0.9;
        if (ninetyPercent > lastSize.longValue()) return;
        else {
            this.printStream.print("Warning!\n " +
                    "Storage at or over 90% capacity\n");
        }
    }
}
