package models

import play.api.libs.json.{Writes, JsPath, Reads}
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
   implicit val storyReads: Reads[Story] = (
     (JsPath \ "userId").read[String],
     (JsPath \ "problem").read[String],
     (JsPath \ "problemTags").read[String],
     (JsPath \ "solution").read[String],
     (JsPath \ "solutionTags").read[String]
     )(Story.apply)

   implicit val storyWrites :Writes[Story] = (
     ( JsPath \ "userId").write[String] and
       (JsPath \ "problem").write[String] and
       (JsPath \ "problemTags").write[String] and
       (JsPath \ "solution").write[String] and
       (JsPath \ "solutionTags").write[String] and
     )(unlift(Story.unapply))


   def apply(userId: String, problem: String, problemTags: String, solution: String, solutionTags: String ): Story = {
      new Story(id, userId, problem, problemTags, solution, solutionTags)
   }

   def unapply(story: Story) = {
      (story.userId, story.problem, story.problemTags, story.solution, story.solutionTags)
   }

   def id = java.util.UUID.randomUUID.toString
 }