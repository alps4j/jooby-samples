/*
 * * Copyright 2017 the original author or authors.
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

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class MvcApiMainTest {
  private static final String PATH = "/mvc";

  @ClassRule
  public static JoobyRule bootstrap = new JoobyRule(new MvcApiMain());

  @Test
  public void getMethod() throws Throwable {
    get(PATH)
      .then()
      .assertThat()
      .body(equalTo("GET"));
  }

  @Test
  public void postMethod() throws Throwable {
    post(PATH)
      .then()
      .assertThat()
      .body(equalTo("POST"));
  }

  @Test
  public void putMethod() throws Throwable {
    put(PATH)
      .then()
      .assertThat()
      .body(equalTo("PUT"));
  }

  @Test
  public void deleteMethod() throws Throwable {
    delete(PATH)
      .then()
      .assertThat()
      .body(equalTo("DELETE"));
  }
}