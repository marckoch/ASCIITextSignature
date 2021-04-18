package stage1

fun main() {
    printSignature("Hyper", "Skill")
}

fun printSignature(firstName: String, lastName: String) {
    val name = firstName + " " + lastName
    val length = name.length + 2

    val topBorder = "_".repeat(length)
    val bottomBorder = "•".repeat(length)

    println(" $topBorder")
    println("| $name |")
    println(" $bottomBorder")
}