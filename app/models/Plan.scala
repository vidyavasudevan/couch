package models

import Util.Util

/**
 * Created by vidya.v on 8/15/15.
 */
class Plan (id: String, pType: PlanType,destinationsByDay: List[(Destination, Int)])

object Plan {

    def apply(pType: PlanType, destinationsByDay: List[(Destination, Int)]): Plan = {
      new Plan(Util.generatedId,pType,destinationsByDay)
    }

  }