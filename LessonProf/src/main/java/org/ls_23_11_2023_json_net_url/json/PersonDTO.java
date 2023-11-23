package org.ls_23_11_2023_json_net_url.json;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonDTO {

    private String name;
    private int age;
    private Address address;

    public PersonDTO(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
