package org.mccandless.arcd

import org.mccandless.arcd.Implicits.DecoratedString
import org.junit.Test
import org.pmw.tinylog.Logger

/**
  *
  * Created by tdm on 6/14/18.
  */
class ArcDiagramSpec extends BaseSpec {

  @Test
  def diagram(): Unit = {
    val s = "abcjdskfhsabcjdsha"
    val arcs: Seq[Arc] = s.getArcs

    arcs should contain (Arc(0, 10, 6))
    arcs filter { _.width > 4 } foreach { a =>
      Logger.info(s"$a, ${s.substring(a.start1, a.start1 + a.width)}  ${s.substring(a.start2, a.start2 + a.width)}")
    }
  }


  @Test
  def exampleFromPaper(): Unit = {
    val s = "28314159479735648231415937"
    val arcs: Seq[Arc] = s.getArcs
    arcs filter { _.width > 4 } foreach { a =>
      Logger.info(s"$a: left arc substring: ${s.substring(a.start1, a.start1 + a.width)} right arc substring: ${s.substring(a.start2, a.start2 + a.width)}")
    }
    arcs should contain (Arc(2, 18, 6))
    s.substring(2, 8) should be ("314159")
    s.substring(18, 24) should be ("314159")
  }
}
