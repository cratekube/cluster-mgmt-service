package io.cratekube.clustermgmt.service

import io.cratekube.clustermgmt.api.ProcessExecutor

/**
 * Executor for the {@code kubectl} binary.
 *
 * @see ProcessExecutor
 */
class KubectlCommand implements ProcessExecutor {
  String executable = '/bin/kubectl'
}
