import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SaleOneItemTest {

    private lateinit var catalog: Catalog
    private lateinit var display: Display
    private lateinit var sale: Sale

    @Before
    fun initialize() {
        display = Display()
        catalog = Catalog(
            mapOf(
                "12345" to "$5.50",
                "23456" to "$7.99"
            )
        )
        sale = Sale(
            display,
            mapOf(
                "12345" to "$5.50",
                "23456" to "$7.99"
            ),
            catalog
        )

    }

    @Test
    fun productFound() {
        sale.onBarcode("12345")

        assertEquals("$5.50", display.getText())
    }

    @Test
    fun anotherProductFound() {
        sale.onBarcode("23456")

        assertEquals("$7.99", display.getText())
    }

    @Test
    fun productNotFound() {
        sale.onBarcode("22222")

        assertEquals("Product not found for 22222", display.getText())
    }

    @Test
    fun anotherProductNotFound() {
        sale = Sale(display, emptyMap(), catalog)

        sale.onBarcode("33333")

        assertEquals("Product not found for 33333", display.getText())
    }

    @Test
    fun emptyBarcode() {
        sale = Sale(display, emptyMap(), catalog)

        sale.onBarcode("")

        assertEquals("Error: barcode is empty", display.getText())
    }
}

class Catalog(private val pricesByBarcode: Map<String, String>) {

    fun hasProductFor(barcode: String) = pricesByBarcode.containsKey(barcode)

    fun getPriceFor(barcode: String) = pricesByBarcode.getValue(barcode)
}

class Sale(
    private val display: Display,
    private val pricesByBarcode: Map<String, String>,
    private val catalog: Catalog
) {

    fun onBarcode(barcode: String) {
        if (barcode.isBlank()) {
            display.displayEmptyBarcode()
        } else {
            if (catalog.hasProductFor(barcode)) {
                val priceAsText = catalog.getPriceFor(barcode)
                display.displayPrice(priceAsText)
            } else {
                display.displayProductNotFound(barcode)
            }
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

    fun displayEmptyBarcode() {
        setText("Error: barcode is empty")
    }

    fun displayProductNotFound(barcode: String) {
        setText("Product not found for $barcode")
    }

    fun displayPrice(priceAsText: String) {
        setText(priceAsText)
    }
}
