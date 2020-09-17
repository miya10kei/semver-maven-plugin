# semver-maven-plugin
This is maven plugin that help you update version with semantic versioning.

## Goal
You can use the following goals.

| goal        |  description                                                 |
| ----------- | ------------------------------------------------------------ |
| patch       | update patch version (e.g. 1.1.1 -> 1.1.2)                   |
| minor       | update minor version (e.g. 1.1.1 -> 1.2.0)                   |
| major       | update major version (e.g. 1.1.1 -> 2.0.0)                   |
| release     | modify to release version (e.g. 1.1.1-SNAPSHOT -> 1.1.1)     |
| pre-release | modify to pre-release version (e.g. 1.1.1 -> 1.1.1-SNAPSHOT) |

## Usage
```bash
$ ./mvnw com.miya10kei.maven.plugins:semver-maven-plugin:patch
```