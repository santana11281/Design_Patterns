package Structural

//        Step 1
//        Create an interface.
internal interface KPImage {
    fun display()
}


//        Step 2
//        Create concrete classes implementing the same interface.
internal class KPRealImage(private val fileName: String) : KPImage {

    init { loadFromDisk(fileName) }

    override fun display() {
        println("Displaying $fileName")
    }

    private fun loadFromDisk(fileName: String) {
        println("Loading $fileName")
    }
}

internal class KProxyImage(private val fileName: String) : KPImage {

    private var realImage: KPRealImage? = null

    override fun display() {

        if (realImage == null) {
            realImage = KPRealImage(fileName)
        }

        realImage!!.display()
    }
}

//        Step 3
//        Use the ProxyImage to get object of RealImage class when required.
    fun main() {

        val image = KProxyImage("test_10mb.jpg")

        //image will be loaded from disk
        image.display()
        println("")

        //image will not be loaded from disk
        image.display()
    }

