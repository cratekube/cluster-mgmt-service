package io.cratekube.clustermgmt.api

import static org.hamcrest.Matchers.allOf
import static org.hamcrest.Matchers.notNullValue
import static org.hamcrest.core.Every.everyItem
import static org.valid4j.Assertive.require
import static org.valid4j.matchers.ArgumentMatchers.notEmptyString

/**
 * Provides a simple API for executing binaries.
 * <p>Classes implementing this trait need to provide an {@code executable} property.
 * The property should have the absolute path to the binary to execute.</p>
 */
trait ProcessExecutor {
  /**
   * Gets the absolute path of the executable for this process executor.
   *
   * @return the executable path
   */
  abstract String getExecutable()

  /**
   * Executes the configured binary using the provided options.
   *
   * @param workingDir the working directory of the subprocess, or
   *             {@code null} if the subprocess should inherit
   *             the working directory of the current process.
   * @param opts varags of options, each value must be {@code non-null} and {@code non-empty}
   * @return the executed process
   */
  Process exec(File workingDir, String... opts) {
    require opts?.toList(), allOf(notNullValue(), everyItem(notEmptyString()))
    return "${executable} ${opts.join(' ')}".execute(null, workingDir)
  }
}
