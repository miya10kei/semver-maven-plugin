package com.miya10kei.maven.plugins.semver;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "patch")
public class PatchMojo extends AbstractSemverMojo {
  @Override
  public void execute() throws MojoExecutionException {
    var version = new Version(project.getVersion());
    var operator = new PomOperator(project, session, pluginManager);
    operator.updateVersion(version.patch());
  }
}
