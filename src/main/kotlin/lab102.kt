/*
Kotlin Bootcamp
*/

fun main(){
	println("Kotlin Bootcamp  - Lab 01 02")
}


/*
Conditional expressions
https://kotlinlang.org/docs/reference/basic-syntax.html#using-conditional-expressions

 */
fun maxOf(a: Int, b: Int): Int {
	if (a > b) {
		return a
	} else {
		return b
	}
}

/*
In Kotlin, if can also be used as an expression:
*/
fun maxOf2(a: Int, b: Int) = if (a > b) a else b

/*
Nullable values and null checks
https://kotlinlang.org/docs/reference/basic-syntax.html#using-nullable-values-and-checking-for-null
A reference must be explicitly marked as nullable when null value is possible.

Return null if str does not hold an integer:
*/

fun parseInt(str: String): Int? {
	return 0
}

/*
Use a function returning nullable value:
 */
fun printProduct(arg1: String, arg2: String) {
	val x = parseInt(arg1)
	val y = parseInt(arg2)

	// Using `x * y` yields error because they may hold nulls.
	if (x != null && y != null) {
		// x and y are automatically cast to non-nullable after null check
		println(x * y)
	}
	else {
		println("'$arg1' or '$arg2' is not a number")
	}
}
/*
or
 */
fun printProduct2(arg1: String, arg2: String) {
	val x = parseInt(arg1)
	val y = parseInt(arg2)

	if (x == null) {
		println("Wrong number format in arg1: '$arg1'")
		return
	}
	if (y == null) {
		println("Wrong number format in arg2: '$arg2'")
		return
	}

// x and y are automatically cast to non-nullable after null check
	println(x * y)
}

/*
Type checks and automatic casts
https://kotlinlang.org/docs/reference/basic-syntax.html#using-type-checks-and-automatic-casts

The is operator checks if an expression is an instance of a type.
If an immutable local variable or property is checked for a specific type, there's no need to cast it explicitly:
*/
fun getStringLength(obj: Any): Int? {
	if (obj is String) {
		// `obj` is automatically cast to `String` in this branch
		return obj.length
	}

	// `obj` is still of type `Any` outside of the type-checked branch
	return null
}

/*
or
 */

fun getStringLength2(obj: Any): Int? {
	if (obj !is String) return null

	// `obj` is automatically cast to `String` in this branch
	return obj.length
}
/*
or even
 */
fun getStringLength3(obj: Any): Int? {
	// `obj` is automatically cast to `String` on the right-hand side of `&&`
	if (obj is String && obj.length > 0) {
		return obj.length
	}

	return null
}


/*
for loop
https://kotlinlang.org/docs/reference/basic-syntax.html#using-a-for-loop
*/

fun loop01() {
	val items = listOf("apple", "banana", "kiwifruit")
	for (item in items) {
		println(item)
	}

	// OR:

	for (index in items.indices) {
		println("item at $index is ${items[index]}")
	}
}




/*
while loop
https://kotlinlang.org/docs/reference/basic-syntax.html#using-a-while-loop
*/
fun loop02() {
	val items = listOf("apple", "banana", "kiwifruit")
	var index = 0
	while (index < items.size) {
		println("item at $index is ${items[index]}")
		index++
	}
}
/*
when expression
https://kotlinlang.org/docs/reference/basic-syntax.html#using-when-expression
*/
fun describe(obj: Any): String =
	when (obj) {
		1          -> "One"
		"Hello"    -> "Greeting"
		is Long    -> "Long"
		!is String -> "Not a string"
		else       -> "Unknown"
	}

/*
Ranges
https://kotlinlang.org/docs/reference/basic-syntax.html#using-ranges
Check if a number is within a range using in operator:
*/
fun ranges01() {
	val x = 10
	val y = 9
	if (x in 1..y + 1) {
		println("fits in range")
	}
}

fun ranges02() {
	val x = 11
	val y = 9
	if (x in 1..y+1) {
		println("fits in range")
	} else {
		println("not fits in range")
	}
}

/*
Check if a number is out of range:
 */

fun ranges03() {
	val list = listOf("a", "b", "c")

	if (-1 !in 0..list.lastIndex) {
		println("-1 is out of range")
	}
	if (list.size !in list.indices) {
		println("list size is out of valid list indices range, too")
	}
}

/*
Iterating over a range:
 */
fun ranges04() {
	for (x in 1..5) {
		print(x)
	}
}

/*
or over a progression:
 */

fun ranges05() {
	for (x in 1..10 step 2) {
		print(x)
	}
	println()
	for (x in 9 downTo 0 step 3) {
		print(x)
	}
}
