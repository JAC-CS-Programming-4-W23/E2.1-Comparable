# Exercise 2.1 - ⚖️ Comparable

## 🎯 Objectives

- **Implement** Java's `Comparable` interface to compare non-primitive data types using generics.

## 🔨 Setup

1. Clone the repo (or download the zip) for this exercise, which you can find [here](https://github.com/JAC-CS-Programming-4-W23/E2.1-Comparable).
2. Start IntelliJ, go to `File -> Open...`, and select the cloned/downloaded folder.
3. If at the top it says "Project JDK is not defined", click "Setup JDK" on the top right, and select the JDK version you have installed on your machine.

   ![Setup JDK](./images/Setup-JDK.png)

4. To get the unit tests to work, open `PokemonTest.java` and add JUnit to the classpath:

   ![Setup Tests](./images/Setup-Tests.png)

   - Just click "OK" on the resulting dialogue window and all the test-related red squigglies should disappear.

## 🔍 Context

From [the Java docs](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html):

> [The Comparable] interface imposes a total ordering on the objects of each class that implements it. This ordering is referred to as the class's *natural ordering*, and the class's `compareTo` method is referred to as its *natural comparison method*.

If our class implements the `Comparable` interface, we must then override the `compareTo()` method.

```java
public interface Comparable<T> {
    int compareTo(T rhs);
}
```

- `<T>` is referred to as a *generic type*.
  - If you're unfamiliar with generic types, [here's](https://docs.oracle.com/javase/tutorial/java/generics/types.html) an excellent tutorial straight from the Java docs!
- `rhs` is an abbreviation for "right-hand side".
  - When we compare two things, we usually write something like `x < y`, where `x` is the expression on the "left" (`lhs`) and `y` is the expression on the "right" (`rhs`).
  - The object we call `compareTo()` on would then implicitly be the expression on the "left" and the one that we pass in would be the expression on the "right".
- `int` is the return type which should be a **negative integer, zero, or a positive integer** if `lhs` (this object) is **less than, equal to, or greater than** `rhs` (the object passed in).

## 🚦 Let's Go

1. Implement the `Pokemon` class to track the Pokemon's `name`, `type`, and `level`.
   - Use an [`enum`](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) for the `type`.
2. Implement [`Comparable`]((https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)) for the `Pokemon` class.
   - The order priority is: first by `name` (alphabetical) and then by `level` (increasing).
   - Ex. A Bulbasaur is "less than" a Charmander because B comes before C alphabetically.
   - Ex. A level 1 Bulbasaur is "less than" a level 2 Bulbasaur because while their names are the same, their levels are not.
   - Ex. A level 1 Bulbasaur is "equal to" another level 1 Bulbasaur because both their names and levels are the same.

### Comparing Numbers

Note that numeric objects use minus (`-`) to implement `compareTo`.

1. If we're comparing the numbers 1 and 2, then we can simply do `1 - 2 == -1`. Since `compareTo` must return a **negative** integer if the left-hand side expression is less than the right-hand side, this works!

2. The same works in reverse, `2 - 1 == 1`, and we know `compareTo` must return a **positive** integer if the left-hand side expression is greater than the right-hand side.

3. `1 - 1 == 0`, and we know `compareTo` must return a **positive** integer if the left-hand side expression is greater than the right-hand side.

Imagine if `x`, `y` were ints: `x.compareTo(y)`

```java
int compareTo(int rhs) {
    return this - rhs;
}
```
