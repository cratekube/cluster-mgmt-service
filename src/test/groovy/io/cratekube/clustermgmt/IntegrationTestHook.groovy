package io.cratekube.clustermgmt

import io.cratekube.clustermgmt.modules.IntegrationTestModule
import ru.vyarus.dropwizard.guice.GuiceBundle
import ru.vyarus.dropwizard.guice.hook.GuiceyConfigurationHook

/**
 * Hook used to modify Guice modules for integration specs.
 */
class IntegrationTestHook implements GuiceyConfigurationHook {
  @Override
  void configure(GuiceBundle.Builder builder) {
    builder.modulesOverride(new IntegrationTestModule())
  }
}
