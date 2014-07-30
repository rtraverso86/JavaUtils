JavaUtils
=========

A collection of general purpose methods and tools for Java projects.


# Overview of packages

## `it.riccardotraverso.java.*`

Contains many helper classes which are meant to provide support for handling classes of the `java.*` package.
Some examples of contents in sub-packages are:

- `it.riccardotraverso.java.io`: `CloseableUtils`
- `it.riccardotraverso.java.lang`: `IterableUtils`, `StringUtils`, `Strategy`
- `it.riccardotraverso.java.nio`: `FilesUtils`
- `it.riccardotraverso.java.utils`: `ArrayUtils`, `ListUtils`

## `it.riccardotraverso.json`

It is a small library for generating Abstract Syntax Trees for JSON (without support for parsing),
printing out the corresponding JSON code. The data structure supports easy manipulation via
user-defined visitors.

## `it.riccardotraverso.xml`

Another small library for printing formatted XML code. It does not support Abstract Syntax Trees.
The main class is `XmlStringBuilder`, which contains most of the functionalities. For formatting
tag attributes in XML a distinct helper class is provided.
