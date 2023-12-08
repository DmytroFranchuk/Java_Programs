package org.ls_2023_12_07_Thread2.model1_ConsumerProducer;

public class Candy {
    private static int count = 0;
    private final int id;

    public int getId() {
        return id;
    }

    public Candy() {
        this.id = count++;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass() && ((Candy) obj).id == this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
