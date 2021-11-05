/*
Kotlin Bootcamp
*/

fun main() {
	println("Kotlin Bootcamp  - Lab 01 04")
}


/*
Collections
https://kotlinlang.org/docs/reference/basic-syntax.html#using-collections
*/

/*
Iterating over a collection:
*/
fun collection01() {
	val items = listOf("banana", "avocado", "apple", "kiwifruit")
	for (item in items) {
		println(item)
	}
}

/*
Checking if a collection contains an object using in operator:
*/

fun collection02() {
	val items = listOf("banana", "avocado", "apple", "kiwifruit")
	when {
		"orange" in items -> println("juicy")
		"apple" in items -> println("apple is fine too")
	}
}

/*
Using lambda expressions to filter and map collections:
 */

fun collection03() {
	val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
	fruits
		.filter { it.startsWith("a") }
		.sortedBy { it }
		.map { it.toUpperCase() }
		.forEach { println(it) }
}
