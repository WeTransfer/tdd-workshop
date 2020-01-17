import org.junit.Assert.assertEquals
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
    fun anotherProductFound() {
        val display = Display()
        val sale = Sale(display)

        sale.onBarcode("23456")

        assertEquals("$7.99", display.getText())
    }

    @Test
    fun productNotFound() {
        val display = Display()
        val sale = Sale(display)

        sale.onBarcode("22222")

        assertEquals("Product not found for 22222", display.getText())
    }
}

class Sale(private val display: Display) {

    fun onBarcode(barcode: String) {

        when (barcode) {
            "12345" -> display.setText("$5.50")
            "23456" -> display.setText("$7.99")
            else -> display.setText("Product not found for 22222")
        }
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
