package javatest.reader;

import javatest.exception.EndOfStreamException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SlowCharacterReaderTest {

    private final CharacterReader characterReader = new SlowCharacterReader();

    @Test
    public void GettingCharactersFromMethod() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            sb.append(characterReader.getNextChar());
        }

        assertEquals("Alice was beginning", sb.toString());
    }

    @Test
    public void ThrowingExceptionWhenStreamEnds() {
        assertThrows(EndOfStreamException.class, () -> {
            while (true) {
                characterReader.getNextChar();
            }
        });
    }
}