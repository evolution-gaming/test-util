package com.evolutiongaming.util

import org.mockito.ArgumentMatchers.argThat
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.{Answer, Stubber}
import org.mockito.{ArgumentCaptor, ArgumentMatcher, Mockito}

import scala.reflect.ClassTag
import scala.util.Try

object MockitoHelper {

  def arg[T](f: T => Any)(implicit tag: ClassTag[T]): T = {
    val matcher = new ArgumentMatcher[T] {
      def matches(argument: T): Boolean = tag.unapply(argument).exists(x => Try(f(x)).isSuccess)
    }
    argThat[T](matcher)
  }

  def argType[T](implicit tag: ClassTag[T]): T = arg[T](_ => ())

  def ans[T](f: InvocationOnMock => T): Answer[T] = new Answer[T] {
    def answer(invocation: InvocationOnMock): T = f(invocation)
  }

  def ans1[A, T](f: A => T): Answer[T] = new Answer[T] {
    def answer(invocation: InvocationOnMock): T = f {
      invocation.getArguments.apply(0).asInstanceOf[A]
    }
  }

  def ans2[A1, A2, T](f: (A1, A2) => T): Answer[T] = new Answer[T] {
    def answer(invocation: InvocationOnMock): T = {
      val arguments = invocation.getArguments
      val a1 = arguments(0).asInstanceOf[A1]
      val a2 = arguments(1).asInstanceOf[A2]
      f(a1, a2)
    }
  }

  def argumentCaptor[T](implicit tag: ClassTag[T]): ArgumentCaptor[T] = {
    ArgumentCaptor.forClass(tag.runtimeClass.asInstanceOf[Class[T]])
  }

  def argMatch[T](pf: PartialFunction[T, Boolean]): T = argThat(new ArgumentMatcher[T] {
    def matches(argument: T): Boolean = PartialFunction.cond(argument)(pf)
  })

  def doReturn(o: AnyRef): Stubber = Mockito.doReturn(o, o)
}
