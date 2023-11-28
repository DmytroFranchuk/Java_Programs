package org.pr_2023_11_24_Serializasia.task_4_tobigxml;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlType(name = "owner")
@XmlAccessorType(XmlAccessType.FIELD)
public class Owner {
    @XmlAttribute(name = "owner_name")
    private String name;

    @XmlElement(name = "phone")
    private String cellphone;

    public Owner() {
    }

    public Owner(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(name, owner.name) && Objects.equals(cellphone, owner.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cellphone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return String.format("Владелец: имя - %s, телефон - %s",
                name,
                cellphone);
    }
}
