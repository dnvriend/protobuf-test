/*
 * Copyright 2015 Dennis Vriend
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

package com.github.dnvriend.simple

import com.github.dnvriend.TestSpec
import docs.persistence.proto.SeatReserved

class SeatReservedTest extends TestSpec {

  "SeatReserved" should "be a case class" in {
    SeatReserved("1", 1, None) should matchPattern {
      case SeatReserved(_, _, _) ⇒
    }
  }

  it should "be converted to a byte array" in {
    SeatReserved("1", 1, None).toByteArray should matchPattern {
      case e: Array[Byte] ⇒
    }
  }

  it should "be parsed from a byte array" in {
    val array: Array[Byte] = SeatReserved("1", 1, None).toByteArray
    SeatReserved.parseFrom(array) should matchPattern {
      case SeatReserved("1", 1, None) ⇒
    }
  }

  it should "be parsed from a field map" in {
    SeatReserved.fromFieldsMap(Map(1 -> "1", 2 -> 1, 3 -> None)) should matchPattern {
      case SeatReserved("1", 1, None) ⇒
    }
  }

  it should "be updated" in {
    SeatReserved("1", 1, None).copy(seatType = Option("a better seat")) should matchPattern {
      case SeatReserved("1", 1, Some("a better seat")) ⇒
    }
  }
}
