package models

import play.api.libs.json._
import play.api.libs.json.Writes._
import play.api.libs.functional.syntax._

/**
 * Created by vidya.v on 5/25/15.
 */
class Story(
     val id: String,
     val userId: String,
     val problem: String,
     val problemTags: String,
     val solution: String,
     val solutionTags: String
 )

 object Story {
   implicit val storyReader  = (
       (__ \ "userId").read[String] and
       (__ \ "problem").read[String] and
       (__ \ "problemTags").read[String] and
       (__ \ "solution").read[String] and
       (__ \ "solutionTags").read[String]
     )(Story.apply _)

     implicit val storyWriter  = (
       (__ \ "id").write[String] and
       (__ \ "userId").write[String] and
       (__ \ "problem").write[String] and
       (__ \ "problemTags").write[String] and
       (__ \ "solution").write[String] and
       (__ \ "solutionTags").write[String]
     )(Story.unapply _)

     def id = java.util.UUID.randomUUID.toString

     def apply(userId: String, problem: String, problemTags: String, solution: String, solutionTags: String) = {
       new Story(id, userId, problem, problemTags, solution, solutionTags)
     }

     def unapply(s: Story) = {
       (s.id, s.userId, s.problem, s.problemTags, s.solution, s.solutionTags)
     }
 }