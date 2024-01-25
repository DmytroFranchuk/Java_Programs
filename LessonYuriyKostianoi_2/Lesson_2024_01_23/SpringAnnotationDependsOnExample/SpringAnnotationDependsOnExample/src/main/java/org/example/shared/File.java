package org.example.shared;

import org.springframework.stereotype.Component;

@Component
public class File {

    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = this.text + text;
    }
}
