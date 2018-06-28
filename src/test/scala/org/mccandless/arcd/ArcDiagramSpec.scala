package org.mccandless.arcd

import org.mccandless.arcd.Implicits.DecoratedString
import org.junit.Test
import org.pmw.tinylog.Logger

/**
  *
  * Created by tdm on 6/14/18.
  */
class ArcDiagramSpec extends BaseSpec {

  private def logLongArcs(s: String, arcs: Seq[Arc], width: Int): Unit = {
    arcs filter { _.width > width } foreach { a =>
      Logger.info(s"$a, ${s.substring(a.start1, a.start1 + a.width)}  ${s.substring(a.start2, a.start2 + a.width)}")
    }
  }

  @Test
  def diagram(): Unit = {
    val s = "abcjdskfhsabcjdsha"
    val arcs: Seq[Arc] = s.getArcs

    arcs should contain(Arc(0, 10, 6))
    logLongArcs(s, arcs, 4)
  }


  @Test
  def exampleFromPaper(): Unit = {
    val s = "28746391479735648274639137"
    val arcs: Seq[Arc] = s.getArcs
    logLongArcs(s, arcs, 4)
    arcs should contain (Arc(2, 18, 6))
    s.substring(2, 8) should be ("746391")
    s.substring(18, 24) should be ("746391")
  }


  @Test
  def repeatedExample(): Unit = {
    val s = "1234567abcde1234567fghij1234567"

    val arcs: Seq[Arc] = s.getArcs
    logLongArcs(s, arcs, 6)
  }
}
