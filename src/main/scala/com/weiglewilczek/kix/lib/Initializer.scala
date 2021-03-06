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
package lib

import model._
import Group._
import lib.DateHelpers._

import net.liftweb.util.TimeHelpers._

/**
 * Initializes the match schedule. In order to set up the "real" match schedule
 * complete initTeamsAndGames().
 */
object Initializer {

  /**
   * Initializes "for real".
   */
  def initTeamsAndGames() {

    // Group A
    val a1 = team(A, "South Afrika", "http://www.nationalflaggen.de/images/flaggen/flagge-suedafrika-flagge-rechteckig-10x15.gif")
    val a2 = team(A,"Mexico", "http://www.nationalflaggen.de/images/flaggen/flagge-mexiko-flagge-rechteckig-10x15.gif")
    val a3 = team(A,"Urugay", "http://www.nationalflaggen.de/images/flaggen/flagge-uruguay-flagge-rechteckig-10x15.gif")
    val a4 = team(A,"France", "http://www.nationalflaggen.de/images/flaggen/flagge-frankreich-flagge-rechteckig-10x15.gif")
    Game.create.group(A).team1(a1).team2(a2).date(date("11", _1600)).location(_J_SC).save
    Game.create.group(A).team1(a3).team2(a4).date(date("11", _2030)).location(_C).save
    Game.create.group(A).team1(a1).team2(a3).date(date("16", _2030)).location(_T).save
    Game.create.group(A).team1(a4).team2(a2).date(date("17", _1330)).location(_P).save
    Game.create.group(A).team1(a2).team2(a3).date(date("22", _1600)).location(_R).save
    Game.create.group(A).team1(a4).team2(a1).date(date("22", _1600)).location(_M).save

    // Group B
    val b1 = team(B,"Argentina", "http://www.nationalflaggen.de/images/flaggen/flagge-argentinien-flagge-rechteckig-10x15.gif")
    val b2 = team(B,"Nigeria", "http://www.nationalflaggen.de/images/flaggen/flagge-nigeria-flagge-rechteckig-10x15.gif")
    val b3 = team(B,"Korea Republic", "http://www.nationalflaggen.de/images/flaggen/flagge-suedkorea-flagge-rechteckig-10x15.gif")
    val b4 = team(B,"Greece", "http://www.nationalflaggen.de/images/flaggen/flagge-griechenland-flagge-rechteckig-10x16.gif")
    Game.create.group(B).team1(b1).team2(b2).date(date("12", _1330)).location(_J_EP).save
    Game.create.group(B).team1(b3).team2(b4).date(date("12", _1600)).location(_NP).save
    Game.create.group(B).team1(b1).team2(b3).date(date("17", _2030)).location(_J_SC).save
    Game.create.group(B).team1(b4).team2(b2).date(date("17", _1600)).location(_M).save
    Game.create.group(B).team1(b2).team2(b3).date(date("22", _2030)).location(_D).save
    Game.create.group(B).team1(b4).team2(b1).date(date("22", _2030)).location(_P).save

    // Group C
    val c1 = team(C,"England", "http://www.nationalflaggen.de/images/flaggen/flagge-england-flagge-rechteckig-10x17.gif")
    val c2 = team(C,"USA", "http://www.nationalflaggen.de/images/flaggen/flagge-vereinigte-staaten-von-amerika-usa-flagge-rechteckig-10x15.gif")
    val c3 = team(C,"Algeria", "http://www.nationalflaggen.de/images/flaggen/flagge-algerien-flagge-rechteckig-10x15.gif")
    val c4 = team(C,"Slovenia", "http://www.nationalflaggen.de/images/flaggen/flagge-slowenien-flagge-rechteckig-10x15.gif")
    Game.create.group(C).team1(c1).team2(c2).date(date("12", _2030)).location(_R).save
    Game.create.group(C).team1(c3).team2(c4).date(date("13", _1330)).location(_P).save
    Game.create.group(C).team1(c1).team2(c3).date(date("18", _2030)).location(_C).save
    Game.create.group(C).team1(c4).team2(c2).date(date("18", _1600)).location(_J_EP).save
    Game.create.group(C).team1(c2).team2(c3).date(date("23", _1600)).location(_T).save
    Game.create.group(C).team1(c4).team2(c1).date(date("23", _1600)).location(_NP).save

    // Group D
    val d1 = team(D,"Germany", "http://www.nationalflaggen.de/images/flaggen/flagge-deutschland-flagge-rechteckig-10x15.gif")
    val d2 = team(D,"Australia", "http://www.nationalflaggen.de/images/flaggen/flagge-australien-flagge-rechteckig-10x19.gif")
    val d3 = team(D,"Serbia", "http://www.nationalflaggen.de/images/flaggen/flagge-serbien-flagge-rechteckig-10x15.gif")
    val d4 = team(D,"Ghana", "http://www.nationalflaggen.de/images/flaggen/flagge-ghana-flagge-rechteckig-10x18.gif")
    Game.create.group(D).team1(d1).team2(d2).date(date("13", _1600)).location(_D).save
    Game.create.group(D).team1(d3).team2(d4).date(date("13", _2030)).location(_T).save
    Game.create.group(D).team1(d1).team2(d3).date(date("18", _1330)).location(_NP).save
    Game.create.group(D).team1(d4).team2(d2).date(date("19", _1330)).location(_R).save
    Game.create.group(D).team1(d2).team2(d3).date(date("23", _2030)).location(_N).save
    Game.create.group(D).team1(d4).team2(d1).date(date("23", _2030)).location(_J_SC).save

    // Group E
    val e1 = team(E,"Netherlands", "http://www.nationalflaggen.de/images/flaggen/flagge-niederlande-flagge-rechteckig-10x15.gif")
    val e2 = team(E,"Denmark", "http://www.nationalflaggen.de/images/flaggen/flagge-daenemark-flagge-rechteckig-10x16.gif")
    val e3 = team(E,"Japan", "http://www.nationalflaggen.de/images/flaggen/flagge-japan-flagge-rechteckig-10x15.gif")
    val e4 = team(E,"Cameroon", "http://www.nationalflaggen.de/images/flaggen/flagge-kamerun-flagge-rechteckig-10x15.gif")
    Game.create.group(E).team1(e1).team2(e2).date(date("14", _1330)).location(_J_SC).save
    Game.create.group(E).team1(e3).team2(e4).date(date("14", _1600)).location(_M).save
    Game.create.group(E).team1(e1).team2(e3).date(date("19", _1600)).location(_D).save
    Game.create.group(E).team1(e4).team2(e2).date(date("19", _2030)).location(_T).save
    Game.create.group(E).team1(e2).team2(e3).date(date("24", _2030)).location(_R).save
    Game.create.group(E).team1(e4).team2(e1).date(date("24", _2030)).location(_C).save

    // Group F
    val f1 = team(F,"Italy", "http://www.nationalflaggen.de/images/flaggen/flagge-italien-flagge-rechteckig-10x17.gif")
    val f2 = team(F,"Paraguay", "http://www.nationalflaggen.de/images/flaggen/flagge-paraguay-flagge-rechteckig-10x15.gif")
    val f3 = team(F,"New Zealand", "http://www.nationalflaggen.de/images/flaggen/flagge-neuseeland-flagge-rechteckig-10x15.gif")
    val f4 = team(F,"Slovakia", "http://www.nationalflaggen.de/images/flaggen/flagge-slowakei-flagge-rechteckig-10x15.gif")
    Game.create.group(F).team1(f1).team2(f2).date(date("14", _2030)).location(_C).save
    Game.create.group(F).team1(f3).team2(f4).date(date("15", _1330)).location(_R).save
    Game.create.group(F).team1(f1).team2(f3).date(date("20", _1600)).location(_N).save
    Game.create.group(F).team1(f4).team2(f2).date(date("20", _1330)).location(_M).save
    Game.create.group(F).team1(f2).team2(f3).date(date("24", _1600)).location(_P).save
    Game.create.group(F).team1(f4).team2(f1).date(date("24", _1600)).location(_J_EP).save

    // Group G 
    val g1 = team(G,"Brazil", "http://www.nationalflaggen.de/images/flaggen/flagge-brasilien-flagge-rechteckig-10x15.gif")
    val g2 = team(G,"Korea DPR", "http://www.nationalflaggen.de/images/flaggen/flagge-nordkorea-flagge-rechteckig-10x15.gif")
    val g3 = team(G,"Cote dIvoire", "http://www.nationalflaggen.de/images/flaggen/flagge-elfenbeinkueste-flagge-rechteckig-10x15.gif")
    val g4 = team(G,"Portugal", "http://www.nationalflaggen.de/images/flaggen/flagge-portugal-flagge-rechteckig-10x15.gif")
    Game.create.group(G).team1(g1).team2(g2).date(date("15", _2030)).location(_J_EP).save
    Game.create.group(G).team1(g3).team2(g4).date(date("15", _1600)).location(_NP).save
    Game.create.group(G).team1(g1).team2(g3).date(date("20", _2030)).location(_J_SC).save
    Game.create.group(G).team1(g4).team2(g2).date(date("21", _1330)).location(_C).save
    Game.create.group(G).team1(g2).team2(g3).date(date("25", _1600)).location(_N).save
    Game.create.group(G).team1(g4).team2(g1).date(date("25", _1600)).location(_D).save

    // Group H
    val h1 = team(H,"Spain", "http://www.nationalflaggen.de/images/flaggen/flagge-spanien-flagge-rechteckig-10x14.gif")
    val h2 = team(H,"Switzerland", "http://www.nationalflaggen.de/images/flaggen/flagge-schweiz-flagge-quadratisch-10x10.gif")
    val h3 = team(H,"Honduras", "http://www.nationalflaggen.de/images/flaggen/flagge-honduras-flagge-rechteckig-10x14.gif")
    val h4 = team(H,"Chile", "http://www.nationalflaggen.de/images/flaggen/flagge-chile-flagge-rechteckig-10x15.gif")
    Game.create.group(H).team1(h1).team2(h2).date(date("16", _1600)).location(_D).save
    Game.create.group(H).team1(h3).team2(h4).date(date("16", _1330)).location(_N).save
    Game.create.group(H).team1(h1).team2(h3).date(date("21", _2030)).location(_J_EP).save
    Game.create.group(H).team1(h4).team2(h2).date(date("21", _1600)).location(_NP).save
    Game.create.group(H).team1(h2).team2(h3).date(date("25", _2030)).location(_M).save
    Game.create.group(H).team1(h4).team2(h1).date(date("25", _2030)).location(_T).save
  }

  /**
   * Initializes "for testing only".
   */
  def initTeamsAndGames4Testing() {
    val now = TimeSpan(millis)

    // Group A
    val a1 = team(A, "South Afrika", "http://www.nationalflaggen.de/images/flaggen/flagge-suedafrika-flagge-rechteckig-10x15.gif")
    val a2 = team(A,"A2")
    val a3 = team(A,"A3")
    val a4 = team(A,"A4")
    Game.create.group(A).team1(a1).team2(a2).date(now - ( 1 hour   )).location(_J_SC).save
    Game.create.group(A).team1(a3).team2(a4).date(now + ( 2 minute )).location(_C).save
    Game.create.group(A).team1(a1).team2(a3).date(now + ( 5 minutes)).location(_T).save
    Game.create.group(A).team1(a4).team2(a2).date(now + (10 minutes)).location(_P).save
    Game.create.group(A).team1(a2).team2(a3).date(now + (30 minutes)).location(_R).save
    Game.create.group(A).team1(a4).team2(a1).date(now + ( 1 hour   )).location(_M).save

    // Group B
    val b1 = team(B,"B1")
    val b2 = team(B,"B2")
    val b3 = team(B,"B3")
    val b4 = team(B,"B4")
    Game.create.group(B).team1(b1).team2(b2).date(now - ( 1 hour   )).location(_J_EP).save
    Game.create.group(B).team1(b3).team2(b4).date(now + ( 2 minute )).location(_NP).save
    Game.create.group(B).team1(b1).team2(b3).date(now + ( 5 minutes)).location(_J_SC).save
    Game.create.group(B).team1(b4).team2(b2).date(now + (10 minutes)).location(_M).save
    Game.create.group(B).team1(b2).team2(b3).date(now + (30 minutes)).location(_D).save
    Game.create.group(B).team1(b4).team2(b1).date(now + ( 1 hour   )).location(_P).save

    // Group C
    val c1 = team(C,"C1")
    val c2 = team(C,"C2")
    val c3 = team(C,"C3")
    val c4 = team(C,"C4")
    Game.create.group(C).team1(c1).team2(c2).date(now - ( 1 hour   )).location(_R).save
    Game.create.group(C).team1(c3).team2(c4).date(now + ( 2 minute )).location(_P).save
    Game.create.group(C).team1(c1).team2(c3).date(now + ( 5 minutes)).location(_C).save
    Game.create.group(C).team1(c4).team2(c2).date(now + (10 minutes)).location(_J_EP).save
    Game.create.group(C).team1(c2).team2(c3).date(now + (30 minutes)).location(_T).save
    Game.create.group(C).team1(c4).team2(c1).date(now + ( 1 hour   )).location(_NP).save

    // Group D
    val d1 = team(D,"D1")
    val d2 = team(D,"D2")
    val d3 = team(D,"D3")
    val d4 = team(D,"D4")
    Game.create.group(D).team1(d1).team2(d2).date(now - ( 1 hour   )).location(_D).save
    Game.create.group(D).team1(d3).team2(d4).date(now + ( 2 minute )).location(_T).save
    Game.create.group(D).team1(d1).team2(d3).date(now + ( 5 minutes)).location(_NP).save
    Game.create.group(D).team1(d4).team2(d2).date(now + (10 minutes)).location(_R).save
    Game.create.group(D).team1(d2).team2(d3).date(now + (30 minutes)).location(_N).save
    Game.create.group(D).team1(d4).team2(d1).date(now + ( 1 hour   )).location(_J_SC).save

    // Group E
    val e1 = team(E,"E1")
    val e2 = team(E,"E2")
    val e3 = team(E,"E3")
    val e4 = team(E,"E4")
    Game.create.group(E).team1(e1).team2(e2).date(now - (1 hour )).location(_J_SC).save
    Game.create.group(E).team1(e3).team2(e4).date(now + (2 hours)).location(_M).save
    Game.create.group(E).team1(e1).team2(e3).date(now + (4 hours)).location(_D).save
    Game.create.group(E).team1(e4).team2(e2).date(now + (6 hours)).location(_T).save
    Game.create.group(E).team1(e2).team2(e3).date(now + (1 day  )).location(_R).save
    Game.create.group(E).team1(e4).team2(e1).date(now + (2 days )).location(_C).save

    // Group F
    val f1 = team(F,"F1")
    val f2 = team(F,"F2")
    val f3 = team(F,"F3")
    val f4 = team(F,"F4")
    Game.create.group(F).team1(f1).team2(f2).date(now - (1 hour )).location(_C).save
    Game.create.group(F).team1(f3).team2(f4).date(now + (2 hours)).location(_R).save
    Game.create.group(F).team1(f1).team2(f3).date(now + (4 hours)).location(_N).save
    Game.create.group(F).team1(f4).team2(f2).date(now + (6 hours)).location(_M).save
    Game.create.group(F).team1(f2).team2(f3).date(now + (1 day  )).location(_P).save
    Game.create.group(F).team1(f4).team2(f1).date(now + (2 days )).location(_J_EP).save

    // Group G 
    val g1 = team(G,"G1")
    val g2 = team(G,"G2")
    val g3 = team(G,"G3")
    val g4 = team(G,"G4")
    Game.create.group(G).team1(g1).team2(g2).date(now - (1 hour )).location(_J_EP).save
    Game.create.group(G).team1(g3).team2(g4).date(now + (2 hours)).location(_NP).save
    Game.create.group(G).team1(g1).team2(g3).date(now + (4 hours)).location(_J_SC).save
    Game.create.group(G).team1(g4).team2(g2).date(now + (6 hours)).location(_C).save
    Game.create.group(G).team1(g2).team2(g3).date(now + (1 day  )).location(_N).save
    Game.create.group(G).team1(g4).team2(g1).date(now + (2 days )).location(_D).save

    // Group H
    val h1 = team(H,"H1")
    val h2 = team(H,"H2")
    val h3 = team(H,"H3")
    val h4 = team(H,"H4")
    Game.create.group(H).team1(h1).team2(h2).date(now - (1 hour )).location(_D).save
    Game.create.group(H).team1(h3).team2(h4).date(now + (2 hours)).location(_N).save
    Game.create.group(H).team1(h1).team2(h3).date(now + (4 hours)).location(_J_EP).save
    Game.create.group(H).team1(h4).team2(h2).date(now + (6 hours)).location(_NP).save
    Game.create.group(H).team1(h2).team2(h3).date(now + (1 day  )).location(_M).save
    Game.create.group(H).team1(h4).team2(h1).date(now + (2 days )).location(_T).save
  }

  private val _1330 = "13:30"
  private val _1600 = "16:00"
  private val _2030 = "20:30"

  private val _J_SC = "Johannesburg (Soccer City)"
  private val _J_EP = "Johannesburg (Ellis Park)"
  private val _N = "Nelspruit"
  private val _R = "Rustenburg"
  private val _M = "Mangaung/Bloemfonstein"
  private val _C = "Cape Town"
  private val _D = "Durban"
  private val _P = "Polokwane"
  private val _NP = "Nelson Mandela Bay"
  private val _T = "Tshwane/Pretoria"

  private def team(group: Group.Value, name: String) = {
    val team = Team.create.group(group).name(name)
    team.save
    team
  }

  private def team(group: Group.Value, name: String, ensignUrl: String) = {
    val team = Team.create.group(group).name(name).ensignUrl(ensignUrl)
    team.save
    team
  }

  private def date(dd: String, time: String) = "2010-06-%sT%sGMT+2:00".format(dd, time)
}
