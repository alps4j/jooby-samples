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

package org.jooby.sample;

import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestApiJacksonMainTest {
  private static final String MVC_PATH = "/mvc/rest";
  private static final String SCRIPT_PATH = "/script/rest";

  @ClassRule
  public static JoobyRule bootstrap = new JoobyRule(new RestApiJacksonMain());

  @Test
  public void scriptGet() {
    get(SCRIPT_PATH)
      .then()
      .assertThat()
      .body("firstName", equalTo("Luke"));
  }

  @Test
  public void scriptPost() {
    given()
      .queryParams(
        "firstName", "Obi-Wan",
        "lastName", "Kenobi")
      .post(SCRIPT_PATH)
      .then()
      .assertThat()
      .body("firstName", equalTo("Obi-Wan"));
  }

  @Test
  public void mvcGet() {
    get(MVC_PATH)
      .then()
      .assertThat()
      .body("firstName", equalTo("Luke"));
  }

  @Test
  public void mvcPost() {
    given()
      .queryParams(
        "firstName", "Leia",
        "lastName", "Organa")
      .post(MVC_PATH)
      .then()
      .assertThat()
      .body("firstName", equalTo("Leia"));
  }
}