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

## License ##

[MIT](https://github.com/Volune/java-functions/blob/master/LICENSE)
