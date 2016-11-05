# JMMPresentation
## JCStress is required
# Clone
```
$ hg clone http://hg.openjdk.java.net/code-tools/jcstress/ jcstress
$ cd jcstress
$ hg update 223:bda9fbee58c8
```
# Build
```
$ mvn clean install -pl tests-custom -am
$ java -jar tests-custom/target/jcstress.jar -h
```
