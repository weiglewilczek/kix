/**
 * Copyright 2009-2010 WeigleWilczek and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weiglewilczek.kix
package model

import lib._

import net.liftweb.http.S.?
import net.liftweb.mapper._
import net.liftweb.common._
import net.liftweb.util.Helpers._
import scala.xml.{NodeSeq, Text}

/**
 * Helper for a persistent tip.
 */
object Tip extends Tip with LongKeyedMetaMapper[Tip] {

  def findByUser(user: Box[User]) =
    user map { u => findAll(By(Tip.user, u.id),
                            PreCache(Tip.game))
    } openOr Nil

  def findByUserAndGameId(user: Box[User], gameId: Long) =
    user map { u => find(By(Tip.user, u.id), By(Tip.game, gameId)) } openOr Empty

  def findNotByUserLikeUserName(user: Box[User], name: String) =
    user map { u => findNotByUserIdLikeUserName(u.id, name) } openOr Nil

  private def findNotByUserIdLikeUserName(userId: Long, name: String) = {
    val trimmedName = name.trim
    lazy val queryName = if (trimmedName endsWith "%") trimmedName else trimmedName + "%" 
    if (trimmedName.isEmpty)
      findAll(NotBy(Tip.user, userId),
              PreCache(Tip.game))
    else 
      findAll(NotBy(Tip.user, userId), 
              In(Tip.user, User.id, Like(User.firstName, queryName)),
              PreCache(Tip.game))
  }
}

/**
 * A persistent tip.
 */
class Tip extends LongKeyedMapper[Tip] with IdPK {

  object user extends MappedLongForeignKey(this, User)

  object game extends MappedGame(this) {
    override def selectableGames = {
      val userTips: List[Long] = Tip findAll By(Tip.user, user.is) map { _.game.is }
      Game.findAll filter { game =>
        !(userTips contains game.id.is) && game.date.after(now)
      }
    }
  }

  object goals1 extends MappedRange(this, Result.GoalRange)

  object goals2 extends MappedRange(this, Result.GoalRange)

  object points extends MappedInt(this)

  def goals = goals1.is + " : " + goals2.is

  def toForm =
    (goals1.toForm openOr NodeSeq.Empty) ++
    Text(" : ") ++ 
    (goals2.toForm openOr NodeSeq.Empty)

  override def getSingleton = Tip
}
