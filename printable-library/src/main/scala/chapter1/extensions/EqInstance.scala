package chapter1.extensions

import cats.Eq
import chapter1.model.Cat
import cats.instances.all._
import cats.syntax.eq._

object EqInstance {
  implicit val catsEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      (cat1.age === cat2.age) &&
        (cat1.name === cat2.name) &&
        (cat1.color === cat2.color)
    }
}
