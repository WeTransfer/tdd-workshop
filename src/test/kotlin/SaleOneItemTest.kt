import org.junit.Assert.assertEquals
import org.junit.Test

class SaleOneItemTest {

    @Test
    fun productFound() {
        val display = Display()
        val sale = Sale()

        sale.onBarcode("12345")

        assertEquals("$5.50", display.getText())
    }
}

class Sale {
    fun onBarcode(barcode: String) {
    }
}

class Display {
    fun getText(): String {
        return "$5.50"
    }

}
