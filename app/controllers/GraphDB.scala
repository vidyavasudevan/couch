package controllers

import com.tinkerpop.blueprints.{Edge, Vertex}
import com.tinkerpop.blueprints.impls.orient.OrientGraph
/**
 * Created by vidya.v on 8/18/15.
 */
object GraphDB {

  def graphWrapper[T](f: OrientGraph => T): T = {
    implicit val  graph: OrientGraph = new OrientGraph("plocal:~/Workspace/GraphDB");
    val ret = f(graph)
    graph.commit
    graph.shutdown
    ret
  }

  def addVertex(name: String) = {
    graphWrapper {
      graph =>
        val luca: Vertex  = graph.addVertex("1", "name", "Luca"); // 1st OPERATION: IMPLICITLY BEGIN A TRANSACTION
        val marko: Vertex  = graph.addVertex("2", "name", "Marko");
        val lucaKnowsMarko: Edge  = graph.addEdge("3", luca, marko, "knows");
        lucaKnowsMarko.getLabel
    }
  }

}
