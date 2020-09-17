package com.miya10kei.maven.plugins.semver;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

abstract class AbstractSemverMojo extends AbstractMojo {
  @Parameter(property = "project", defaultValue = "${project}", readonly = true, required = true)
  protected MavenProject project;

  @Parameter(property = "session", defaultValue = "${session}", readonly = true, required = true)
  protected MavenSession session;

  @Component protected BuildPluginManager pluginManager;
}
