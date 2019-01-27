package chapter1.model

import chapter1.library.Printable

final case class Cat(name: String, age: Int, color: String)

object Cat{
  implicit val printable = new Printable[Cat] {
    override def format(value: Cat): String = s"${value.name} is a ${value.age} years old ${value.color} cat"
  }
}
