package com.miya10kei.maven.plugins.semver;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VersionTest {
  @ParameterizedTest
  @CsvSource(value = {"0.0.1, 0.0.2", "1.1.1-SNAPSHOT, 1.1.2-SNAPSHOT"})
  void shouldUpdatePatchVersion(String version, String expected) {
    // when
    var actual = new Version(version).patch();
    // then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {"0.0.1, 0.1.0", "1.1.1-SNAPSHOT, 1.2.0-SNAPSHOT"})
  void shouldUpdateMinorVersion(String version, String expected) {
    // when
    var actual = new Version(version).minor();
    // then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {"0.0.1, 1.0.0", "1.1.1-SNAPSHOT, 2.0.0-SNAPSHOT"})
  void shouldUpdateMajorVersion(String version, String expected) {
    // when
    var actual = new Version(version).major();
    // then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {"0.0.1, 0.0.1", "1.1.1-SNAPSHOT, 1.1.1"})
  void shouldModifyToReleaseVersion(String version, String expected) {
    // when
    var actual = new Version(version).release();
    // then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {"0.0.1, 0.0.1-SNAPSHOT", "1.1.1-SNAPSHOT, 1.1.1-SNAPSHOT"})
  void shouldModifyToPreReleaseVersion(String version, String expected) {
    // when
    var actual = new Version(version).preRelease();
    // then
    assertEquals(expected, actual);
  }
}
