package org.ls_02_11_2023_nestedClass.nestedClass;

public class Question {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Question.Type type) {
        this.type = type;
    }
    // Static nested classes
    public static class Type {
        public static final Type SINGLE_CHOICE = new Type();
        public static final Type MULTI_CHOICE = new Type();
        public static final Type TEXT = new Type();

        private Type() {
        }
    }
}
