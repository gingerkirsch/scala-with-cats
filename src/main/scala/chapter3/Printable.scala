package chapter3

trait Printable[A]{ self =>
  def format(value: A): String
  def contramap[B](func: B => A): Printable[B] = new Printable[B] {
    override def format(value: B): String = self.format(func(value))
  }
}

object PrintableInstances{
  implicit val stringPrintable: Printable[String] = new Printable[String] {
    override def format(value: String): String = "\"" + value + "\""
  }
  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
  implicit val booleanPrintable: Printable[Boolean] = new Printable[Boolean] {
    override def format(value: Boolean): String = if (value) "yes" else "no"
  }
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)
  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(format(value))
}


object PrintableSyntax {
  implicit class PrintableOps[A](value: A){
    def format(implicit printable: Printable[A]): String = printable.format(value)
    def print(implicit printable: Printable[A]): Unit = println(value.format)
  }
}
