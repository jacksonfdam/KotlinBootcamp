/*
Kotlin Bootcamp
*/

/*
Program entry point

An entry point of a Kotlin application is the main function.
*/

fun main() {
    println("Kotlin Bootcamp  - Lab 01 01")
    printHello()
}

fun printHello() {
    println("Hello World")
}

/*
Functions

Function having two Int parameters with Int return type:
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/*
Function with an expression body and inferred return type:
*/
fun sum2(a: Int, b: Int) = a + b

/*
Function returning no meaningful value:
 */
fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

/*
Unit return type can be omitted:
*/
fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

/*
Variables
https://kotlinlang.org/docs/reference/basic-syntax.html#defining-variables

Read-only local variables are defined using the keyword val. They can be assigned a value only once.
 */
fun vars01() {
    val a: Int = 1 // immediate assignment
    val b = 2 // `Int` type is inferred
    val c: Int // Type required when no initializer is provided
    c = 3 // deferred assignment

    val i: Int = 7
    val d: Double = i.toDouble()

    val c: Char = 'c'
    val ic: Int = c.toInt()



    val bitwiseOr = FLAG1 or FLAG2
    val bitwiseAnd = FLAG1 and FLAG2
}

/*
Variables that can be reassigned use the var keyword:
 */
fun vars02() {
    var x = 5 // `Int` type is inferred
    x += 1
}

/*
Top-level variables:
 */
val PI = 3.14
var x2 = 0

fun incrementX() {
    x2 += 1
}

/*
String templates
https://kotlinlang.org/docs/reference/basic-syntax.html#using-string-templates
 */
fun vars03() {
    var a1 = 1
    // simple name in template:
    val s1 = "a is $a1"
    a1 = 2

    // arbitrary expression in template:
    val s2 = "${s1.replace("is", "was")}, but now is $a1"
}
