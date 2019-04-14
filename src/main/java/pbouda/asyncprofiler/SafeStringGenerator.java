package pbouda.asyncprofiler;

public class SafeStringGenerator extends StringGenerator {

    @Override
    public synchronized String generate() {
        return super.generate();
    }
}