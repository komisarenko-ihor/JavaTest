package javatest.reader;

import javatest.exception.EndOfStreamException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SimpleCharacterReaderTest {

    CharacterReader characterReader = new SimpleCharacterReader();

    @Test
    public void GettingCharactersFromMethod() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            sb.append(characterReader.getNextChar());
        }

        assertEquals("It was the best of times", sb.toString());
    }

    @Test
    public void ThrowingExceptionWhenStreamEnds() {
        assertThrows(EndOfStreamException.class, () -> {
            while(true) {
                characterReader.getNextChar();
            }
        });
    }
}