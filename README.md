# Text punctuation analyzer

## Requirements

1. Apache Maven >= 3.6
2. Kotlin + JVM 1.3
3. SWI-Prolog
4. JPL >= 7.6.0

## Building

Use Apache Maven to build app, using command:
```shell script
mvn clean install -Djpl.path=<jpl_jar>
```
replacing `<jpl_jar>` with the path to the _jpl-7.6.0.jar_ file.

## Deploying

Based on information on [JPL Wiki](https://github.com/SWI-Prolog/packages-jpl/wiki/Installing-&-Using-JPL-in-Linux):

Finally, to be **able to use JPL** you may need to make sure that:

>* Extend environment library `LD_PRELOAD` for system to pre-load `libswipl.so`: 
>    * `export LD_PRELOAD=libswipl.so:$LD_PRELOAD`
>    * Check [this post](https://answers.ros.org/question/132411/unable-to-load-existing-owl-in-semantic-map-editor/) and [this one](https://blog.cryptomilk.org/2014/07/21/what-is-preloading/) about library preloading.
>    * Also, check [this](https://bugs.debian.org/cgi-bin/bugreport.cgi?bug=690734) and [this](https://github.com/yuce/pyswip/issues/10) posts.
>* Extend environment variable `LD_LIBRARY_PATH`  to point to the directory where `libjpl.so` is located:
>    * `export LD_LIBRARY_PATH=/usr/lib/swi-prolog/lib/amd64/`
>* Make sure `jpl.jar` is in your Java CLASSPATH. This is generally automatically done if environment variable `SWI_HOME_DIR` is correctly set to `/usr/lib/swi-prolog/`.