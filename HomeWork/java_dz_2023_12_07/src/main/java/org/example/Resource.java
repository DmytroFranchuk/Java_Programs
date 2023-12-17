package org.example;

import java.util.UUID;

public class Resource {
    private UUID id;

    public Resource() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                '}';
    }
}
