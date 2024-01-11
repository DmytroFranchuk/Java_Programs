package org.lesson_Annotations.lesson_materials.AnnotationExample.example.comment;

import java.lang.annotation.*;

/**
 * Описание аннотации, которая заменит комментарии
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassPreamble {
    String author();

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    // Можно использовать массив
    String[] reviewers();
}
