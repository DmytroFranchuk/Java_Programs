package person;

public class ExtendedPerson extends Person {
    private final boolean isMale;
    public String taxNumber;

    public ExtendedPerson(String name, int age, boolean isMale) {
        super(name, age);
        this.isMale = isMale;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
