# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2/26/2026

### Added

- EMNumber class
    - Methods
        - mantissa() (getter)
        - exponent() (getter)
        - isZero()
        - add(EMNumber n)
        - subtract(EMNumber n)
        - multiply(EMNumber n)
        - divide(EMNumber n)
    - Constructors
        - (double mantissa, int exponent)
        - (int n)
        - (double n)
        - (NaturalNumber n)
