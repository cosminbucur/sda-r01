package com.sda.spring.core.editor;

public class TextEditor {

    private SpellChecker spellChecker;
    private TextFormatter textFormatter;
    private ImageConverter imageConverter;

    public TextEditor() {
        spellChecker = new CoolSpellChecker();
        textFormatter = new TextFormatter();
        imageConverter = new ImageConverter();
    }

    public TextEditor(SpellChecker spellChecker, TextFormatter textFormatter, ImageConverter imageConverter) {
        this.spellChecker = spellChecker;
        this.textFormatter = textFormatter;
        this.imageConverter = imageConverter;
    }

    public String spellCheck() {
        return spellChecker.checkSpelling();
    }

    public String format() {
        return textFormatter.format();
    }

    public String convert() {
        return imageConverter.convert();
    }

    public String checkAll() {
        String result1 = spellChecker.checkSpelling();
        String result2 = textFormatter.format();
        String result3 = imageConverter.convert();
        return result1 + result2 + result3; // checkformatconvert
    }
}
