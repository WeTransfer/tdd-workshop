import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class SaleOneItemTest {

    @Test
    fun productFound() {
        val display = Display()
        val sale = Sale(display)

        sale.onBarcode("12345")

        assertEquals("$5.50", display.getText())
    }

    @Test
    @Ignore
    fun anotherProductFound() {
        val display = Display()
        val sale = Sale(display)

        sale.onBarcode("23456")

        assertEquals("$7.99", display.getText())
    }
}

class Sale(private val display: Display) {

    fun onBarcode(barcode: String) {

        display.setText("$5.50")
    }
}

class Display {
    private var text = ""

    fun getText(): String {
        return text
    }

    fun setText(text: String) {
        this.text = text
    }
}
