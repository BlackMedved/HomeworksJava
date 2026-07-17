package alfa.homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLUtilsTest {
    @Test
    public void shouldReturnRightXMLTagIfPassedString() {
        String tagName = "div";
        String resultTag = XMLUtils.createEmptyElement(tagName);
        Assertions.assertEquals("<div></div>", resultTag, "Возвращается некорректный xml тег при " +
                "передаче непустой строки!");
    }

    @Test
    public void shouldReturnInvalidTagWhenPassedStringIsNull() {
        String tagName = null;
        String resultTag = XMLUtils.createEmptyElement(tagName);
        Assertions.assertEquals("<invalid/>", resultTag, "Возвращается некорректный xml тег при " +
                "передаче строки null!");
    }

    @Test
    public void shouldReturnInvalidTagWhenPassedStringIsEmpty() {
        String tagName = "";
        String resultTag = XMLUtils.createEmptyElement(tagName);
        Assertions.assertEquals("<invalid/>", resultTag, "Возвращается некорректный xml тег при " +
                "передаче пустой строки!");
    }
}
