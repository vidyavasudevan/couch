package models

import Util.Util
/**
 * Created by vidya.v on 8/15/15.
 */
class Destination (
      id: String,
      name: String
  )
object Destination {

  def apply(name: String, id: String): Destination = Destination(id, name)
  def apply(name: String): Destination = Destination(Util.generatedId, name)

}