JavaUtils
=========

A collection of general purpose methods and tools for Java projects.


## Overview of packages

A complete, up-to-date javadoc is available at the address http://rtraverso86.github.io/JavaUtils/.  

### `it.riccardotraverso.java.*`

Contains many helper classes which are meant to provide support for handling classes of the `java.*` package.
Some examples of contents in sub-packages are:

- `it.riccardotraverso.java.io`: `CloseableUtils`, `MultiFileInputStream` 
- `it.riccardotraverso.java.lang`: `IterableUtils`, `StringUtils`, `Strategy`
- `it.riccardotraverso.java.nio`: `FilesUtils`
- `it.riccardotraverso.java.utils`: `ArrayUtils`, `ListUtils`

### `it.riccardotraverso.json`

It is a small library for generating Abstract Syntax Trees for JSON (without support for parsing),
printing out the corresponding JSON code. The data structure supports easy manipulation via
user-defined visitors.

### `it.riccardotraverso.xml`

Another small library for printing formatted XML code. It does not support Abstract Syntax Trees.
The main class is `XmlStringBuilder`, which contains most of the functionalities. For formatting
tag attributes in XML a distinct helper class is provided.

## License

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
