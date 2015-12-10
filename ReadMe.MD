Example application that tries to replicate https://github.com/rhuss/docker-maven-plugin/issues/259.

Run `mvn package` once and repeat execution of `mvn docker:stop; mvn docker:start` - this sometimes ends up reproducing the issue.