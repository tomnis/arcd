package org.mccandless.arcd

/**
  * Computes the arc diagram for a given String.
  *
  * - define a mapping from the string to the x-axis, with the position of the mth symbol at the point (m/N,0).
  * - a substring T of S corresponds to an interval on the x-axis.
  *   Each essential matching pair (X,Y) in the string is an arc in the final diagram.
  *
  *
  * Created by tdm on 6/15/18.
  */
trait ComputesArcDiagrams {

  val s: String

  private lazy val substrings: Seq[(Int, Int, String)] = {
    val strings = for {
      start <- this.s.indices
      end <- start + 1 until this.s.length
      substr = this.s.substring(start, end)
      if substr.nonEmpty
    } yield (start, end, substr)

    strings.sortBy(_._3)
  }

  def arcDiagram: Seq[Arc] = {
    Seq.empty
  }


  /**
    * A maximal matching pair is a pair of substrings of S, X and Y, which are:
    *
    * 1. Identical. X and Y consist of the same sequence of symbols.
    * 2. Non-overlapping. X and Y do not intersect.
    * 3. Consecutive. X occurs before Y, and there is no substring Z, identical to X and Y, whose
    *    beginning falls between the beginning of X and the beginning of Y.
    * 4. Maximal. There do not exist longer identical non-overlapping substrings X’ and Y’ with X’
    *    containing X and Y’ containing Y’.
    *
    * TODO assume that start1 is before start2?
    */
  def isMaximalMatchingPair(start1: Int, start2: Int, length: Int): Boolean = {
//    require(start1 < start2)
    val substr1: String = this.s.substring(start1, start1 + length)
    val substr2: String = this.s.substring(start2, start2 + length)

    lazy val identical: Boolean = substr1 == substr2
    lazy val nonOverlapping: Boolean = start1 + length <= start2 || start2 + length <= start1
    lazy val consecutive: Boolean = start1 < start2 && {
      val z: String = this.s.substring(start1, start1 + length)
      !this.s.substring(start1, start2 + length).contains(z)
    }
    lazy val maximal: Boolean = {

    }

    identical && nonOverlapping && consecutive && maximal
  }


  /**
    * A repetition region R is a substring of S such that R is made up of a string P repeated two or more
    * times in immediate succession.
    *
    * Each repetition of P is called a fundamental substring for R. For example, in the string ABC010101, the substring
    * “010101” is a repetition region. Each of the “01” substrings is a fundamental substring.
    *
    * @param substring
    * @return
    */
  def isRepetitionRegion(substring: String): Boolean = {
    1 until (substring.length / 2) exists { l: Int => allEqual(substring.sliding(l).toSeq) }
  }


  /**
    * An essential matching pair is a pair of substrings of S, X and Y, which are:
    *
    * 1. A maximal matching pair not contained in any repetition region,
    * 2. Or, a maximal matching pair contained in the same fundamental substring of any repetition region that contains it,
    * 3. Or, two consecutive fundamental substrings for a repetition region.
    *
    * @param start1
    * @param start2
    * @param length
    * @return
    */
  def isEssentialMatchingPair(start1: Int, start2: Int, length: Int): Boolean = {
    false
  }



  def repetitionRegions: Seq[(Int, Int)] = {
    this.substrings.collect {
      case (start, end, substring) if this.isRepetitionRegion(substring) => (start, end)
    }
  }


  def allEqual(strs: Seq[String]): Boolean = {
    strs.forall(_ == strs.head)
  }



}
