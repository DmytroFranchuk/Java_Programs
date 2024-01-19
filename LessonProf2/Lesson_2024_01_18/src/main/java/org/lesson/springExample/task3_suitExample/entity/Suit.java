package org.lesson.springExample.task3_suitExample.entity;

import org.lesson.springExample.task3_suitExample.entity.interfaces.Shirt;
import org.lesson.springExample.task3_suitExample.entity.interfaces.Tie;
import org.lesson.springExample.task3_suitExample.entity.interfaces.Jacket;
import org.lesson.springExample.task3_suitExample.entity.interfaces.Trousers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Suit {
    private Tie tie;
    private Shirt shirt;
    private Jacket jacket;
    private Trousers trousers;

    @Autowired
    public Suit(@Qualifier("bowTie") Tie tie, Shirt shirt, Jacket jacket, Trousers trousers) {
        this.tie = tie;
        this.shirt = shirt;
        this.jacket = jacket;
        this.trousers = trousers;
    }

    public Tie getTie() {
        return tie;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public Jacket getJacket() {
        return jacket;
    }

    public Trousers getTrousers() {
        return trousers;
    }
}
