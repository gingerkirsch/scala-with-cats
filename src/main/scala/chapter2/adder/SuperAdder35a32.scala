package chapter2.adder

import cats.Monoid
import cats.syntax.semigroup._
import cats.instances.double._

object SuperAdder35a32 {
  /** def add(items: List[Int]): Int = items.foldLeft(0)((a,b) => a + b) */
  def add(items: List[Int])(implicit m: Monoid[Int]): Int = items.foldLeft(m.empty)(m.combine)
}

case class Order(totalCost: Double, quantity: Double)
object Order{
  implicit val orderMonoid = new Monoid[Order]{
    override def combine(x: Order, y: Order): Order = Order(x.totalCost |+| y.totalCost, x.quantity |+| y.quantity)
    override def empty: Order = Order(0,0)
  }
}
