package stage2

fun main() {
    val name = readLine()!!

    printSignature(name)
}

fun printSignature(name: String) {
    val length = name.length + 4

    val topBorder = "*".repeat(length)
    val bottomBorder = "*".repeat(length)

    println(topBorder)
    println("* $name *")
    println(bottomBorder)
}