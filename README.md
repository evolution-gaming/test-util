# test-util
[![Build Status](https://travis-ci.org/evolution-gaming/test-util.svg)](https://travis-ci.org/evolution-gaming/test-util)
[![Coverage Status](https://coveralls.io/repos/evolution-gaming/test-util/badge.svg)](https://coveralls.io/r/evolution-gaming/test-util)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5a268ddaf673460f894cc824d636a567)](https://www.codacy.com/manual/evolution-gaming/test-util?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=evolution-gaming/test-util&amp;utm_campaign=Badge_Grade)
[![version](https://api.bintray.com/packages/evolutiongaming/maven/test-util/images/download.svg) ](https://bintray.com/evolutiongaming/maven/test-util/_latestVersion)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

## Syntax sugar for Scala around Mockito

```scala
def arg[T](f: T => Any): T ~ argThat[T]
def ans[T](f: InvocationOnMock => T): Answer[T] ~  new Answer[T]
def ans1[A, T](f: A => T): Answer[T] ~ new Answer[T]
def argumentCaptor[T]: ArgumentCaptor[T] ~ ArgumentCaptor.forClass 
```

## Getting Started

```scala
resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies += "com.evolutiongaming" %% "test-util" % "0.0.2"
``` 