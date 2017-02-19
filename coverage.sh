#!/bin/bash
mvn -Dlogback.configurationFile=logback.xml -DdryRun=true clean package coveralls:report -P coverage