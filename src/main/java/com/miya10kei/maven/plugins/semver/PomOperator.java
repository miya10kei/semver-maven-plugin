package com.miya10kei.maven.plugins.semver;

import static org.twdata.maven.mojoexecutor.MojoExecutor.artifactId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.configuration;
import static org.twdata.maven.mojoexecutor.MojoExecutor.element;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executeMojo;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executionEnvironment;
import static org.twdata.maven.mojoexecutor.MojoExecutor.goal;
import static org.twdata.maven.mojoexecutor.MojoExecutor.groupId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.name;
import static org.twdata.maven.mojoexecutor.MojoExecutor.plugin;
import static org.twdata.maven.mojoexecutor.MojoExecutor.version;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

public class PomOperator {
  private final MavenProject project;
  private final MavenSession session;
  private final BuildPluginManager pluginManager;

  /** Constructor. */
  PomOperator(MavenProject project, MavenSession session, BuildPluginManager pluginManager) {
    this.project = project;
    this.session = session;
    this.pluginManager = pluginManager;
  }

  /** Update version on pom.xml. */
  void updateVersion(String version) throws MojoExecutionException {
    executeMojo(
        plugin(groupId("org.codehaus.mojo"), artifactId("versions-maven-plugin"), version("2.8.1")),
        goal("set"),
        configuration(
            element(name("generateBackupPoms"), "false"), element(name("newVersion"), version)),
        executionEnvironment(project, session, pluginManager));
  }
}
