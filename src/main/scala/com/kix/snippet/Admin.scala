/**
 * Copyright 2009 WeigleWilczek and others.
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
package com.kix.snippet

import lib.Initializer
import model._
import net.liftweb.http.S.?
import net.liftweb.http.SHtml._
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq

class Admin {

  def overview(xhtml: NodeSeq) =
    bind("overview", xhtml, 
         "teams" -> Team.findAll.size,
         "games" -> Game.findAll.size,
         "results" -> Result.findAll.size,
         "tipsters" -> User.tipsters.size,
         "tips" -> Tip.findAll.size)
         
  def reset(xhtml: NodeSeq) = submit(?("Reset"), doReset)

  def init(xhtml: NodeSeq) = submit(?("Init"), doInit)

  private def doReset() {
    Tip.bulkDelete_!!()
    User.deleteAllTipsters()
    Result.bulkDelete_!!()
    Game.bulkDelete_!!()
    Team.bulkDelete_!!()
  }

  private def doInit() {
    doReset()
    Initializer.initTeamsAndGames()
  }
}
