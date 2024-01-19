package org._lessonExamples.SpringAnnotationScopeExample.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class SecondComponent {
    private final FirstComponent first;

    @Autowired
    public SecondComponent(FirstComponent first) {
        this.first = first;
    }

    public FirstComponent getFirst() {
        return first;
    }

    @Override
    public String toString() {
        return "I am SecondComponent made using @Component{first=" + first + '}';
    }
}
