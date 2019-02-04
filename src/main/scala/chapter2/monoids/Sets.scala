package chapter2.monoids

object Sets {
  def joinSemigroup[A] = new Semigroup[Set[A]]{
    override def combine(x: Set[A], y: Set[A]): Set[A]= x ++ y
  }

  def unionSemigroup[A] = new Semigroup[Set[A]]{
    override def combine(x: Set[A], y: Set[A]): Set[A] = x | y
  }

  def diffSemigroup[A] = new Semigroup[Set[A]]{
    override def combine(x: Set[A], y: Set[A]): Set[A] = x & y
  }

  def join[A] = new Monoid[Set[A]] {
    override def combine(x: Set[A], y: Set[A]): Set[A] = x ++ y
    override def empty = Set.empty[A]
  }

  def union[A] = new Monoid[Set[A]]{
    override def combine(x: Set[A], y: Set[A]): Set[A] = x | y
    override def empty = Set.empty[A]
  }
}

