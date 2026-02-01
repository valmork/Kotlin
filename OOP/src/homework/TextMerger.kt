package homework

class TextMerger {
    fun mergeText(lines: List<String>): String {
        val result = StringBuilder()
        for (line in lines) {
            result.append(line + "\n")   // Эффективная конкатенация строк
        }
        return result.toString()
    }
}