package parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {
    @Test
    void check() {
        assertTrue(Check.instance.check("xml_parser\\resources\\file.xml", "xml_parser\\resources\\schema.xsd"));
    }
}