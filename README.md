# Portfolio Project

This is a project created by Riley Robert for OSU's CSE 2231 Software II course.

It contains several game objects useful in incremental game development.

## EMNumber

### Representation

An object meant to represent numbers in Exponent-Mantissa format.

Ever seen a number so large in a calculator it was displayed something like:

> 3.447534E61

That is an example of Exponent-Mantissa notation. It conveys extremely large or
small numbers through the use of the Mantissa (the decimal number) and the
Exponent (the number after the E). Simply, the format follows:

> (mantissa) \* 10^(exponent)

This allows for the representation of extremely large numbers with relatively
little screen (and data) space.

### Methods

Simple arithmetic methods like add, subtract, multiply, and divide are available.

Several useful constructors exist to convert more ordinary data types into this
format, such as int, double, OSU's NaturalNumber, and more.

## Game Objects

Listed below are some useful objects pertaining to various incremental game
components.

## Multiplier

A variant of the EMNumber that specifies what GameObject it should multiply to,
dictated by the entires in GameObjectNames.

## Generator

This object takes the amount of itself multiplied by a given Multiplier intended
to create more of another GameObject

## Material

A simplistic GameObject that contains a variable to give a nicer display name,
but also contains amount, type, etc. like other GameObjects.

# Author Notes

This project is unfortunately not in an entirely finished states. There are two
java classes in the src folder to try out some use case examples, but the
original project was meant to be a completed game, which unfortunately,
there was not enough time for. Perhaps some day I'll come back to this and
make a completed version, as I had high hopes for it.

Regardless, I hope the components within this project serve some use.

- Riley Robert
