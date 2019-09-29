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
`%dw 2.0
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
 ++ dyn("Passing function", justLog)`

## Java
location : src/main/java
```
package httpstest;

import java.util.Random;

public class MyUtils {
	public String s ;
	public MyUtils(String str) {
		s = str;
	}
	public static String appendRandom(String base) {
		return base + new Random().nextInt();
	}
	public String getFoo(String here) {
		return  s;
	}
}
```
Can be accessed from DataWeaver as
```
%dw 2.0
output application/json
import java!httpstest::MyUtils
---
{
	"static":MyUtils::appendRandom("myString"),
	"Object": MyUtils::new("constructorstring").s
}

```
NOTE: that it is not possible for DataWeave to call the object’s getFoo() method

## DWL File:
```
%dw 2.0
fun concatName(aPerson) = aPerson ++ ' updatedName'
fun stringToDateUTC() = ((now() as String {format: "yyyy-MM-dd'T'HH:mm:ss.SSSZ"} ++ "UTC"
 )) as DateTime {format: "yyyy-MM-dd'T'HH:mm:ss.SSS"}

```
Can be accessed from DataWeave as
```
%dw 2.0
output application/json

import * from modules::commonFunction
---

{
 "Name" : concatName("givenName"),
 "CreatedDate" : stringToDateUTC()
}
```
