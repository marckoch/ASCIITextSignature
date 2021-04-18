package stage3

val LETTERS: Map<Char, Array<String>> = mapOf(
    'A' to arrayOf("____", "|__|", "|  |"),
    'B' to arrayOf("___ ", "|__]", "|__]"),
    'C' to arrayOf("____", "|   ", "|___"),
    'D' to arrayOf("___ ", "|  \\", "|__/"),
    'E' to arrayOf("____", "|___", "|___"),
    'F' to arrayOf("____", "|___", "|   "),
    'G' to arrayOf("____", "| __", "|__]"),
    'H' to arrayOf("_  _", "|__|", "|  |"),
    'I' to arrayOf("_", "|", "|"),
    'J' to arrayOf(" _", " |", "_|"),
    'K' to arrayOf("_  _", "|_/ ", "| \\_"),
    'L' to arrayOf("_   ", "|   ", "|___"),
    'M' to arrayOf("_  _", "|\\/|", "|  |"),
    'N' to arrayOf("_  _", "|\\ |", "| \\|"),
    'O' to arrayOf("____", "|  |", "|__|"),
    'P' to arrayOf("___ ", "|__]", "|   "),
    'Q' to arrayOf("____", "|  |", "|_\\|"),
    'R' to arrayOf("____", "|__/", "|  \\"),
    'S' to arrayOf("____", "[__ ", "___]"),
    'T' to arrayOf("___", " | ", " | "),
    'U' to arrayOf("_  _", "|  |", "|__|"),
    'V' to arrayOf("_  _", "|  |", " \\/ "),
    'W' to arrayOf("_ _ _", "| | |", "|_|_|"),
    'X' to arrayOf("_  _", " \\/ ", "_/\\_"),
    'Y' to arrayOf("_   _", " \\_/ ", "  |  "),
    'Z' to arrayOf("___ ", "  / ", " /__"),
    ' ' to arrayOf("    ", "    ", "    "),
)

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val tag = readLine()!!

    printSignature(name.toUpperCase(), tag)
}

fun buildNameLines(name: String, letters: Map<Char, Array<String>>, fontsize: Int): List<List<String>> {
    val lines = MutableList<MutableList<String>>(fontsize) { mutableListOf() }

    name.map { c -> letters[c] }
        .map { array ->
            if (array != null) {
                for (i in array.indices) {
                    lines[i].add(array[i])
                }
            }
        }
    return lines
}

fun printSignature(name: String, tag: String) {
    val lines = buildNameLines(name, LETTERS, 3)

    val nameLength = lines[0].joinToString(" ").length

    val isOdd = (nameLength - tag.length) % 2 != 0
    val oddBlank = if (isOdd) " " else "" // used to fill on right half

    val maxLength = kotlin.math.max(nameLength, tag.length)
    val absDiff = kotlin.math.abs(nameLength - tag.length)

    val noOfBlanks = (absDiff + 4) / 2 // no of blanks on one side (left or right)
    val blanks = " ".repeat(noOfBlanks)

    val nameLongerThanTag = nameLength > tag.length

    val blanksToPadName = if (nameLongerThanTag) "  " else blanks
    val oddBlankToPadName = if (nameLongerThanTag) "" else oddBlank
    val blanksToPadTag = if (nameLongerThanTag) blanks else "  "
    val oddBlankToPadTag = if (nameLongerThanTag) oddBlank else ""

    // 1 star + 2 blanks + ... + 2 blanks + 1 star
    val border = "*".repeat(1 + 2 + maxLength + 2 + 1)

    val paddedNameLines = mutableListOf<String>()
    for (line in lines) {
        paddedNameLines.add("*" + blanksToPadName + line.joinToString(" ") + blanksToPadName + oddBlankToPadName + "*")
    }

    val tagLine = "*" + blanksToPadTag + tag + blanksToPadTag + oddBlankToPadTag + "*"

    println(border)
    paddedNameLines.map { println(it) }
    println(tagLine)
    println(border)
}