package com.miya10kei.maven.plugins.semver;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class Version {
  private static final Pattern pattern = Pattern.compile("^(\\d+).(\\d+).(\\d+)(-SNAPSHOT)?$");
  private String version;

  public Version(String version) {
    if (!pattern.matcher(version).find()) {
      throw new IllegalArgumentException("Illegal version format: " + version);
    }
    this.version = version;
  }

  public String patch() {
    var m = pattern.matcher(version);
    if (m.find()) {
      return setAndGetVersion(m.group(1), m.group(2), up(m.group(3)), m.group(4) == null);
    }
    throw new RuntimeException();
  }

  public String minor() {
    var m = pattern.matcher(version);
    if (m.find()) {
      return setAndGetVersion(m.group(1), up(m.group(2)), "0", m.group(4) == null);
    }
    throw new RuntimeException();
  }

  public String major() {
    var m = pattern.matcher(version);
    if (m.find()) {
      return setAndGetVersion(up(m.group(1)), "0", "0", m.group(4) == null);
    }
    throw new RuntimeException();
  }

  public String release() {
    var m = pattern.matcher(version);
    if (m.find()) {
      return setAndGetVersion(m.group(1), m.group(2), m.group(3), true);
    }
    throw new RuntimeException();
  }

  public String preRelease() {
    var m = pattern.matcher(version);
    if (m.find()) {
      return setAndGetVersion(m.group(1), m.group(2), m.group(3), false);
    }
    throw new RuntimeException();
  }

  private String setAndGetVersion(String major, String minor, String patch, boolean isRelease) {
    var format = isRelease ? "%s.%s.%s" : "%s.%s.%s-SNAPSHOT";
    this.version = format(format, major, minor, patch);
    return this.version;
  }

  private String up(String version) {
    return String.valueOf(parseInt(version) + 1);
  }
}
