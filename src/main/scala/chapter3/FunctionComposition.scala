package chapter3

import cats.instances.function._
import cats.syntax.functor._

object FunctionComposition {
  val func1: Int => Double = (x: Int) => x.toDouble
  val func2: Double => Double = (y: Double) => y * 2

  (func1 map func2)(1)            // composition using map
  (func1 andThen func2)(1)    // composition using andThen
  func2(func1(1))                  // manual composition

  /** Function composition is sequencing.
    * Calling map doesn't run an operation but chains it. */
  val func =
    ((x: Int) => x.toDouble)
    .map(_ + 1)
    .map(_ * 2)
    .map(_ + "!")
}
