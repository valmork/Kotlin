package homework

class ClickProcessor {
    private val clickListeners = mutableMapOf<String, ClickListener>()

    fun registerClickListener(elementId: String, listener: ClickListener) {
        clickListeners[elementId] = listener
    }

    fun processClick(elementId: String): String {
        val listener = clickListeners[elementId]
        return listener?.onClick(elementId) ?: "No listener registered for $elementId"
    }
}

// Реализуйте метод setupClickListeners
fun setupClickListeners(clickProcessor: ClickProcessor) {
    val button1 = clickProcessor.registerClickListener("button1", object : ClickListener {
        override fun onClick(elementId: String): String {
            return "Button 1 clicked!"
        }
    })

    val button2 = clickProcessor.registerClickListener("button2", object : ClickListener {
        override fun onClick(elementId: String): String {
            return "Button 2 clicked!"
        }
    })

    val button3 = clickProcessor.registerClickListener("button3", object : ClickListener {
        override fun onClick(elementId: String): String {
            return "Button 3 clicked!"
        }
    })
}