package io.cratekube.clustermgmt.service

import io.cratekube.clustermgmt.api.ProcessExecutor
import org.valid4j.errors.RequireViolation
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class ProcessExecutorTest extends Specification {
  @Subject ProcessExecutor subject
  File f = new File('/')

  def setup() {
    subject = new RkeCommand()
  }

  @Unroll
  def 'Exec requires valid params: file=#file, opts=#opts'() {
    when:
    subject.exec(file, *opts)

    then:
    thrown RequireViolation

    where:
    file   | opts
    null   | null
    this.f | null
    this.f | ['', ' ', null]
  }
}
