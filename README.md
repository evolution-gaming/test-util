# test-util

## Syntax sugar for Scala around Mockito

```
def arg[T](f: T => Any): T ~ argThat[T]
def ans[T](f: InvocationOnMock => T): Answer[T] ~  new Answer[T]
def ans1[A, T](f: A => T): Answer[T] ~ new Answer[T]
def argumentCaptor[T]: ArgumentCaptor[T] ~ ArgumentCaptor.forClass 
```