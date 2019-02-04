package chapter2.monoids

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A]{
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]) = monoid
}

object Laws{
  def associativity[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean = {
    m.combine(x, m.combine(y,z)) == m.combine(m.combine(x,y), z)
  }

  def identity[A](x: A)(implicit m: Monoid[A]): Boolean = {
    (m.combine(m.empty, x) == x) && (m.combine(x, m.empty) == x)
  }
}

object Test{
  def identity[A](samples: Seq[A])(monoid: Monoid[A]): Boolean = {
    val testSet = samples.map(Laws.identity(_)(monoid))
    testSet.forall(result => result)
  }

  def associativity[A](samples: Seq[A])(monoid: Monoid[A]): Boolean = {
    val testSet = samples.map(sample => Laws.associativity(sample, sample, sample)(monoid))
    testSet.forall(result => result)
  }
}
