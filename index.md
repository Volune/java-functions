---
layout: page
title: java-functions
---
{% include JB/setup %}
A set of utility functions to manipulate Java 8 method references

## Example ##

```java
students.forEach(Functions.bind2(Person::setGraduated, true));
```

## To Do List ##

 - Tag first release and publish artifacts

## License ##

[MIT](https://github.com/Volune/java-functions/blob/master/LICENSE)
