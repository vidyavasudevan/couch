package models

import Util.Util
/**
 * Created by vidya.v on 8/13/15.
 */
class Trip (val id: String, val destination: Destination)

object Trip {
  def apply(destination: Destination): Trip = new Trip(Util.generatedId, destination)
}
