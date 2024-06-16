# :information_source: Since security issues keep popping up and keeping things up to date here doesn't seem to be worth the effort, this repository has been archived. 

Example application that tries to replicate [fabric8io/docker-maven-plugin#259](https://github.com/fabric8io/docker-maven-plugin/issues/259)<sup>*</sup>.

Run `mvn package` once and repeat execution of `mvn docker:stop; mvn docker:start` - this sometimes ends up reproducing the issue.  
If Maven results in a "successful build", then the application logged a specific string and thus the problem didn't occur.
Sometimes though, an "Invalid log format error" occurs, or logging seizes to work.
This causes Maven to fail - yet there may be other reasons why Maven fails. 

<sup>*</sup> _this was originally https://github.com/rhuss/docker-maven-plugin/issues/259_.
