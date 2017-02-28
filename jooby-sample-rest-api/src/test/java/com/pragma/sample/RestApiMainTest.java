/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pragma.sample;

import com.pragma.sample.entity.Person;
import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class RestApiMainTest {
  private static final String MVC_PATH = "/mvc/rest";
  private static final String SCRIPT_PATH = "/script/rest";

  @ClassRule
  public static JoobyRule bootstrap = new JoobyRule(new RestApiMain());

  @Test
  public void scriptGet() {
    get(SCRIPT_PATH)
      .then()
      .assertThat()
      .body(is(Person.LUKE));
  }

  @Test
  public void scriptPost() {
    post(SCRIPT_PATH, "Obi-Wan", "Kenobi", LocalDate.of(1971, 3, 31))
      .then()
      .assertThat()
      .body(is(Person.LUKE));
  }

  @Test
  public void mvcGet() {
    get(MVC_PATH)
      .then()
      .assertThat()
      .body(instanceOf(Person.class));
  }
}