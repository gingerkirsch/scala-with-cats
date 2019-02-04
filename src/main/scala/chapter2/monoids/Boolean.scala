package chapter2.monoids

object Boolean {
  val andSemigroup = new Semigroup[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x & y
  }

  val orSemigroup = new Semigroup[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x | y
  }

  val xorSemigroup = new Semigroup[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x ^ y
  }

  val equalSemigroup = new Semigroup[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x == y
  }

  val and = new Monoid[Boolean] {
    override def combine(x: Boolean, y: Boolean): Boolean = x & y
    override def empty = true
  }

  val mor = new Monoid[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x | y
    override def empty = false
  }

  val xor = new Monoid[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x ^ y
    override def empty = false
  }

  val equal = new Monoid[Boolean]{
    override def combine(x: Boolean, y: Boolean): Boolean = x == y
    override def empty = true
  }
}
