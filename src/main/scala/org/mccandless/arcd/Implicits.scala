package org.mccandless.arcd

object Implicits {

  /**
    * Decorates `s` with arc functions.
    * @param s
    */
  implicit class DecoratedString(val s: String) extends ComputesArcDiagrams {

    def getArcs: Seq[Arc] = this.arcDiagram
  }
}
