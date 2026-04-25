# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.04.24

## Fixes

- EMNumber had significant errors when adding/subtracting similarly sized numbers that has been fixed.
- The heirarchy of Generator1 ended up causing compareTo() to compare the wrong objects, which has been fixed.

## Additions

### Tests

- Unit tests were added or improved for the following components:
  - EMNumber
  - GameObject
  - GeneratorSecondary
  - Generator1
  - Material

### Use Cases

Unfortunately, I ran out of time on this project. I wanted to make a game, but
would need much more time to complete something playable. I did my best to
come up with some basic use cases for the various components anyway.

- Compound Generator
  - Semi-simulates things like compound interest
  - A fun example of something that would never appear in game for balance reasons!
  - Shows how to set up generators and use multipliers.
- EMNumber Calculator
  - Allows the user to mess around with the Exponent-Mantissa format of numbers.
  - Showcases basic EMNumber arithmatic.
  - Allows for making some absurdly large or small numbers that would normally
    never nicely display on a calculator

### Reflection

My reflection of this project can be found in docs/Reflection.pdf!
