package org._lessonExamples.SpringAnnotationScopeExample.pojo;

import org.springframework.stereotype.Component;

@Component
public class FirstComponent {

    @Override
    public String toString() {
        return "I'm the FirstComponent made using @Component";
    }
}