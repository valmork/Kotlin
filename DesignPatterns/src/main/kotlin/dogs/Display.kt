package dogs

import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea


class Display {

    fun show(){
        val textArea = JTextArea().apply {
            isEditable = false
            font = Font(Font.SANS_SERIF, Font.PLAIN, 16)
            margin = Insets(32, 32, 32, 32)
        }

        val scrollPane = JScrollPane(textArea)
        JFrame().apply {
            this.isVisible = true
            this.isResizable = false
            this.size = Dimension(600, 600)
            add(scrollPane)
        }

        DogsRepository.getInstance("dogs").addOnDogsChangedListener { newValue ->
            newValue.joinToString("\n").let { textArea.text = it }
        }

    }
}