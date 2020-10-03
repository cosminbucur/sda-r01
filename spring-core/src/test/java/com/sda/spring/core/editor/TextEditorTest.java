package com.sda.spring.core.editor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TextEditorTest {

    @Mock
    SpellChecker spellChecker;

    @Mock
    TextFormatter textFormatter;

    @Mock
    ImageConverter imageConverter;

    @InjectMocks
    TextEditor textEditorWithMocks;

    @Test
    public void givenTextEditor_whenSpellCheck_thenReturnOk() {
        // given
        TextEditor textEditor = new TextEditor();
        String expected = "ok";

        // when
        String actual = textEditor.spellCheck();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testWithDependencyInjection() {
        // given
        SpellChecker spellChecker = new CoolSpellChecker();
        TextFormatter textFormatter = new TextFormatter();
        ImageConverter imageConverter = new ImageConverter();
        TextEditor textEditor = new TextEditor(spellChecker, textFormatter, imageConverter);
        String expected = "ok";

        // when
        String actual = textEditor.spellCheck();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testWithMocks() {
        // given text editor, when spellcheck, then return yes

        // given
        String expected = "yes";
        when(spellChecker.checkSpelling())
            .thenReturn(expected);

        // when
        String actual = textEditorWithMocks.spellCheck();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void givenTextEditor_whenCheckAll_thenReturnFullString() {
        // given
        String expected = "checkformatconvert";
        when(spellChecker.checkSpelling())
            .thenReturn("check");
        when(textFormatter.format())
            .thenReturn("format");
        when(imageConverter.convert())
            .thenReturn("convert");

        // when
        String actual = textEditorWithMocks.checkAll();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
