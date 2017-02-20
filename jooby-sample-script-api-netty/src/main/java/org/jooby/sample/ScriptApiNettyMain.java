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

import org.jooby.Jooby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpMethod.*;

public final class ScriptApiNettyMain extends Jooby {
  private static final Logger log = LoggerFactory.getLogger(ScriptApiNettyMain.class);

  private static final String REQUEST = "%s has been requested!";

  {
    use("/")
      .get(() -> {
        log.info(String.format(REQUEST, GET.toString()));
        return GET.toString();
      })
      .put(() -> {
        log.info(String.format(REQUEST, PUT.toString()));
        return PUT.toString();
      })
      .post(() -> {
        log.info(String.format(REQUEST, POST.toString()));
        return POST.toString();
      })
      .delete(() -> {
        log.info(String.format(REQUEST, DELETE.toString()));
        return DELETE.toString();
      });
  }

  public static void main(String... args) {
    run(ScriptApiNettyMain::new, args);
  }
}
