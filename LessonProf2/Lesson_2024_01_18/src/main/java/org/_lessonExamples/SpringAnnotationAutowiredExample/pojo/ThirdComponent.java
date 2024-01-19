package org._lessonExamples.SpringAnnotationAutowiredExample.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThirdComponent {
    private FirstComponent first;

    public ThirdComponent(FirstComponent first) {
        this.first = first;
    }

    @Autowired
    public void setFirst(FirstComponent first) {
        this.first = first;
        System.out.println("Somebody has used setFirst-method");
    }

    public FirstComponent getFirst() {
        return first;
    }

    @Override
    public String toString() {
        return "I am ThirdComponent made using @Component and @Autowire setter{first=" + first + '}';
    }
}
