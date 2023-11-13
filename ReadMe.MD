Example application that tries to replicate https://github.com/fabric8io/docker-maven-plugin/issues/259 (originally https://github.com/rhuss/docker-maven-plugin/issues/259).

Run `mvn package` once and repeat execution of `mvn docker:stop; mvn docker:start` - this sometimes ends up reproducing the issue.
