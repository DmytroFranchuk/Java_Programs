package org.springExample.task2_Terminator.pojo;

public class JohnConnor {
    private int health;

    public JohnConnor() {
        this.health = 50;
    }

    public int destroyTerminator(Terminator terminator) {
        health -= terminator.getHealth();
        return health;
    }

    @Override
    public String toString() {
        return "JohnConnor{" +
                "health=" + health +
                '}';
    }
}
