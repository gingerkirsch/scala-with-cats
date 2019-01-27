package chapter1

import chapter1.model.Cat
import chapter1.extensions.ShowInstance.catShow
import chapter1.extensions.EqInstance.catsEq
import chapter1.library.PrintableSyntax._
import cats.instances.option._
import cats.syntax.show._
import cats.syntax.eq._
import cats.syntax.option._

object Main extends App {
  val cat = Cat("Maxime", 12, "grey")
  /** My very own implicit extension */
  cat.print

  val anotherCat = Cat("Mona", 6, "black")
  /** Cats show */
  println(anotherCat.show)

  println(cat === cat)
  println(cat === anotherCat)

  val optionCat = Option(cat)
  val optionAnotherCat = Option(anotherCat)

  println(optionCat === optionCat)
  println(optionCat === optionAnotherCat)

  println(cat.some =!= none[Cat])
  println(cat.some === none[Cat])
}
