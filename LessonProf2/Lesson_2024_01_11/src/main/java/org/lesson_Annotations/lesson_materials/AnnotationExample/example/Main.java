package org.lesson_Annotations.lesson_materials.AnnotationExample.example;

import org.lesson_Annotations.lesson_materials.AnnotationExample.example.comment.ClassPreamble;
import org.lesson_Annotations.lesson_materials.AnnotationExample.example.comment.Generation3ListAfter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Generation3ListAfter> clazz = Generation3ListAfter.class;
        ClassPreamble annotation = clazz.getDeclaredAnnotation(ClassPreamble.class);
        System.out.println(annotation.author());
        System.out.println(annotation.date());
        System.out.println(annotation.currentRevision());
        System.out.println(annotation.lastModified());
        System.out.println(annotation.lastModifiedBy());
        System.out.println(Arrays.toString(annotation.reviewers()));
    }
}
