package chapter1.extensions

import cats.Show
import chapter1.model.Cat

object ShowInstance {
  implicit val catShow: Show[Cat] =
    Show.show(t => s"${t.name} is a ${t.age} years old ${t.color} cat")
}
