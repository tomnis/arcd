package org.mccandless.arcd

import org.junit.Test
import org.pmw.tinylog.Logger

/**
  *
  * Created by tdm on 6/14/18.
  */
class ArcDiagramSpec extends BaseSpec with ComputesArcDiagrams {

  val s: String = "abcjdskfhsabcjdsha"

  @Test
  def diagram(): Unit = {

    val arcs: Seq[Arc] = this.arcDiagram

    Logger.info(arcs)

  }
}
