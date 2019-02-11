package chapter3

import PrintableInstances._
import Printable._

import CodecInstances._
import Codec._

object Main extends App {
  final case class Box[A](value: A)

  implicit def boxPrintable[A](implicit p: Printable[A]): Printable[Box[A]] = p.contramap(_.value)

  println(format(Box("hello world")))
  println(format(Box(true)))

  implicit def boxCodec[A](implicit c: Codec[A]): Codec[Box[A]] = c.imap(Box.apply, _.value)

  println(encode(123.4))
  println(decode[Box[Double]]("123.4"))


}
