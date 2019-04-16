package pbouda.asyncprofiler.falsesharing;

import jdk.internal.vm.annotation.Contended;
import org.openjdk.jol.info.ClassLayout;

public class ContendedAnnotation {

    @Contended
    private volatile long value;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(ContendedAnnotation.class).toPrintable());
    }
}
