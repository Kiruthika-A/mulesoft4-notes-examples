# DataWeaver Points to remember:
* [ typeOf("A b"), typeOf([1,2]), typeOf(34), typeOf(true), typeOf({ a : 5 }) ]
  * [ "String", "Array", "Number", "Boolean", "Object" ]

* random()
  * Returns a pseudo-random number greater than or equal to 0.0 and less than 1.0

* randomInt(Number)
  * Returns a pseudo-random whole number from 0 to the specified number (exclusive).

* { "mergeWith" : { "a" : true, "b" : 1} mergeWith { "a" : false, "c" : "Test"} }
  * "mergeWith": {
    "b": 1,
    "a": false,
    "c": "Test"
     }

* p(String)
  * This function returns a string that identifies the value of one of these input properties: Mule property placeholders, System properties, or Environment variables.

* lookup(String, payload(Any), timeoutMillis(Number) - optional)
  * This function enables you to execute a flow within a Mule app and retrieve the resulting payload.

## Common Function Syntax:
```%dw 2.0
output application/java
fun change(str: String)=
	(
		toLower(str) ++ 'update val \n '
	)
fun toLower ( str : String) =
(
	lower(str)
)

fun dyn (val : String, func)= (
	val ++ func()
)

fun justLog () = " This is dynamically called"
---
change ("Function call inside function \n")
 ++ dyn("Passing function", justLog)```
