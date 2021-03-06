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
package snippet

import lib._

import java.util.Locale._
import net.liftweb.common._
import net.liftweb.http.S
import net.liftweb.http.SHtml._
import net.liftweb.util.Helpers._
import scala.xml.{NodeSeq, Text}

class Locales {

  def render(xhtml: NodeSeq) = {
    def path = S.request map { _.request.url.toString } openOr ""
    link(path, () => SessionLocale(Full(GERMANY)), <img src="/images/DE-12x18.gif" alt="DE" title="DE"/>) ++
      Text(" ") ++
      link(path, () => SessionLocale(Full(UK)), <img src="/images/UK-12x18.gif" alt="UK" title="UK"/>)  
  }
}
