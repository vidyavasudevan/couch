package controllers
import anorm._
import models.{Story, User}
import play.api.db.DB
import play.api.Play.current

/**
 * Created by vidya.v on 4/29/15.
 */
object Barista {

  def addUser(user: User) =
    DB.withConnection { implicit connection =>
     val result =  SQL(
        """ INSERT INTO USER
         | VALUES ({id}, {username}, {email}, {password}, {fullname}, {location})"""
         .stripMargin).on(
          "id" -> user.id,
          "username" -> user.username,
          "email" -> user.email,
          "password" -> user.password,
          "fullname" -> user.fullname,
          "location" -> user.location
       ).executeInsert()
    }


  def addStory(story: Story) =
      DB.withConnection {
          implicit connection =>
              val result = SQL(
              """ INSERT INTO STORY
                | VALUES ({id}, {userId}, {problem}, {problemTags}, {solution}, {solutionTags})
              """.stripMargin).on(
                   "id" -> story.id,
                   "userId" -> story.userId,
                   "problem" -> story.problem,
                   "problemTags" -> story.problemTags,
                   "solution" -> story.solution,
                   "solutionTags" -> story.solutionTags
                ).executeInsert()

      }
}
