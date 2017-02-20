/*
 * Copyright 2012-2016 the original author or authors.
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

import org.jooby.test.MockRouter;
import org.junit.Assert;
import org.junit.Test;

public class ScriptApiNettyMainTest {
  @Test
  public void getMethod() throws Throwable {
    final Object get = new MockRouter(new ScriptApiNettyMain()).get("/");

    Assert.assertEquals("GET", get);
  }

  @Test
  public void postMethod() throws Throwable {
    final Object post = new MockRouter(new ScriptApiNettyMain()).post("/");

    Assert.assertEquals("POST", post);
  }

  @Test
  public void putMethod() throws Throwable {
    final Object put = new MockRouter(new ScriptApiNettyMain()).put("/");

    Assert.assertEquals("PUT", put);
  }

  @Test
  public void deleteMethod() throws Throwable {
    final Object delete = new MockRouter(new ScriptApiNettyMain()).delete("/");

    Assert.assertEquals("DELETE", delete);
  }
}