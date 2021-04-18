package stage4

import java.io.File
import java.util.*

val MEDIUM: Map<Char, List<String>> = readFont("./src/main/resources/medium.txt", 5)
val ROMAN: Map<Char, List<String>> = readFont("./src/main/resources/roman.txt", 10)

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val tag = readLine()!!

    printSignature(name, tag)
}

fun printSignature(name: String, tag: String) {
    val nameLines = buildLines(name, ROMAN, 10)
    val nameLength = nameLines[0].joinToString("").length

    val tagLines = buildLines(tag, MEDIUM, 3)
    val tagLength = tagLines[0].joinToString("").length

    val isOdd = (nameLength - tagLength) % 2 != 0
    val oddBlank = if (isOdd) " " else "" // used to fill on right half

    val maxLength = kotlin.math.max(nameLength, tagLength)
    val absDiff = kotlin.math.abs(nameLength - tagLength)

    val noOfBlanks = (absDiff + 4) / 2 // no of blanks on one side (left or right)
    val blanks = " ".repeat(noOfBlanks)

    val nameLongerThanTag = nameLength > tagLength

    val blanksToPadName = if (nameLongerThanTag) "  " else blanks
    val oddBlankToPadName = if (nameLongerThanTag) "" else oddBlank
    val blanksToPadTag = if (nameLongerThanTag) blanks else "  "
    val oddBlankToPadTag = if (nameLongerThanTag) oddBlank else ""

    // 2 '8' + 2 blanks + ... + 2 blanks + 2 '8'
    val border = "8".repeat(2 + 2 + maxLength + 2 + 2)

    val paddedNameLines = mutableListOf<String>()
    for (line in nameLines) {
        paddedNameLines.add("88" + blanksToPadName + line.joinToString("") + blanksToPadName + oddBlankToPadName + "88")
    }

    val paddedTagLines = mutableListOf<String>()
    for (line in tagLines) {
        paddedTagLines.add("88" + blanksToPadTag + line.joinToString("") + blanksToPadTag + oddBlankToPadTag + "88")
    }

    println(border)
    paddedNameLines.map { println(it) }
    paddedTagLines.map { println(it) }
    println(border)
}

fun buildLines(name: String, letters: Map<Char, List<String>>, fontsize: Int): List<List<String>> {
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

fun readFont(filename: String, widthOfSpace: Int): Map<Char, List<String>> {
    val scanner = Scanner(File(filename))
    val letters: MutableMap<Char, List<String>> = mutableMapOf()

    val fontsize = scanner.nextInt()
    val letterCount = scanner.nextInt()
    scanner.nextLine()

    repeat(letterCount) {
        val line = scanner.nextLine()
        val (letter, _) = line.split(" ")
        val listForLetter = mutableListOf<String>()
        repeat(fontsize) {
            listForLetter.add(scanner.nextLine()!!)
        }
        letters[letter[0]] = listForLetter
    }

    val space = " ".repeat(widthOfSpace)
    letters[' '] = List(fontsize) { space }

    return letters
}