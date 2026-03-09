

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CalculatorControllerTest {

    private CalculatorController controller;
    private TextField number1Field;
    private TextField number2Field;
    private Label resultLabel;

    @BeforeEach
    void setUp() {
        controller = new CalculatorController();
        number1Field = new TextField();
        number2Field = new TextField();
        resultLabel = new Label();

        // Inject mocks
        controller.number1Field = number1Field;
        controller.number2Field = number2Field;
        controller.resultLabel = resultLabel;
    }

    @Test
    void testNormalCalculation() {
        number1Field.setText("10");
        number2Field.setText("5");

        controller.onCalculateClick();

        String expected = "Sum: 15.0, Product: 50.0, Subtraction: 5.0, Division: 2.0";
        assertEquals(expected, resultLabel.getText());
    }

    @Test
    void testDivisionByZero() {
        number1Field.setText("10");
        number2Field.setText("0");

        controller.onCalculateClick();

        assertEquals("Division by zero is not allowed!", resultLabel.getText());
    }

    @Test
    void testInvalidNumberInput() {
        number1Field.setText("abc");
        number2Field.setText("5");

        controller.onCalculateClick();

        assertEquals("Please enter valid numbers!", resultLabel.getText());
    }
}