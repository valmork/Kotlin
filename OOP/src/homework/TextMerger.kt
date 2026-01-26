package homework

class TextMerger {
    fun mergeText(lines: List<String>): String {
        var result = StringBuilder()
        for (line in lines) {
            result.append(line + "\n")   // Эффективная конкатенация строк
        }
        return result.toString()
    }
}