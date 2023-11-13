Example application that tries to replicate [fabric8io/docker-maven-plugin#259](https://github.com/fabric8io/docker-maven-plugin/issues/259)<sup>*</sup>.

Run `mvn package` once and repeat execution of `mvn docker:stop; mvn docker:start` - this sometimes ends up reproducing the issue.

<sup>*</sup> _this was originally https://github.com/rhuss/docker-maven-plugin/issues/259_.