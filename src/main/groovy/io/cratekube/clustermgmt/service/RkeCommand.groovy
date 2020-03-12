package io.cratekube.clustermgmt.service

import io.cratekube.clustermgmt.api.ProcessExecutor

/**
 * Executor for the {@code rke} binary.
 *
 * @see ProcessExecutor
 */
class RkeCommand implements ProcessExecutor {
  String executable = '/bin/rke'
}
