package com.sda.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

    // filed injection - evil!
    @Autowired
    private SpellChecker spellChecker;

    private TextFormatter textFormatter;

    private ImageConverter imageConverter;

    // constructor injection - preferred
    // dependency injection
    @Autowired
    public TextEditor(ImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }

    // setter injection
    @Autowired
    public void setTextFormatter(TextFormatter formatter) {
        this.textFormatter = formatter;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }

    public void format() {
        textFormatter.format();
    }

    public void convert() {
        imageConverter.convert();
    }
}
