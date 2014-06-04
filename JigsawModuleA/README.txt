Demo: OSGi
==========

sample bundle with Activator
install it
start it/stop it
list bundle
uninstall it

install file:<path>
e.g.
install file:///D:/stuff/seminars/BG_JUG/Modularity_of_the_Java_Platform/workspace/OSGiBundle/target/org.bgjug.bundle-1.0.0.SNAPSHOT.jar

Demo: Jigsaw
============

Download two editions of Jigsaw JDK 8 early-access builds from:
https://jdk8.java.net/jigsaw/

Open Jigsaw JDK with already installed modules or with base module only.

// jmod tool 
jmod

// list modules with jmod (base and modules image)
jmod list - list of all installed modules

// list modules in a library
jmod -L D:\stuff\seminars\BG_JUG\Modularity_of_the_Java_Platform\jdk8-jigsaw-early-access\jigsaw-modules-8-b42-windows-amd64-27_Jun_2012\jre-base-image\lib\modules list


// compile a module
dir /s /B D:\stuff\seminars\BG_JUG\Modularity_of_the_Java_Platform\workspace\JigsawModuleA\*java > D:\output\sources.txt
javac -d D:\output -modulepath D:\output @D:\output\sources.txt

// single module structure
// multimodule structure
javac -d modules -modulepath modules -sourcepath src \ `find src -name '*.java'`
// javac -modulepath mods src/org.bgjug

// package a module as a jmod file
jpkg -m D:\output\src jmod org.bgjug

od -a org.bgjug@1.0

// install the module
jmod install org.bgjug@1.0

// invoke the installed module
java -m org.bgjug

// remote the module
jmod remove org.bgjug@1.0

// invoke an invokable module
java -m jdk.javac
java -m org.bgjug
java -L juglib -m org.bgjug

// create a module library
// with the -P option a parent module library will be added and it will be searched in 
// case the child one is missing (by default the system module library is used by default)
// (a jmod file can also be installed in a module library)
jmod -L test create
jmod -L test list
// install module in a module library
jmod -L test install D:\output\src org.bgjug
jmod -L test list

// invoke a module from a library
java -L test -m org.bgjug

// remove a module for the module library
// (current workaround is to delete it directly)
rm -rf mlib/com.greetings

// to install a module in a module library
jmod -L mlib install com.greetings@0.1.jmod org.astro@1.2.jmod

// list all modules installed in a module library
jmod -L mlib ls

jmod -L mlib ls -v

jmod -L mlib org.bgjug

// jdeps tool

// installing a module using jlink
jlink -mods javafx,rmi,nashorn -d $JRE
$JRE/bin/java -jar app.jar
javac -mods javafx,rmi,nashorn -d classes *.java 
java -mods javafx,rmi,nashorn -jar app.jar:... ...

// install module from a repo (add repo to jmod first)
jmod add-repo <url>
jmod install -n jdk.tools

jrepo - a tool for creating a Jigsaw module repository

References
==========

OSGi Alliance
	http://www.osgi.org/Main/HomePage
Jigsaw Project
	http://openjdk.java.net/projects/jigsaw/
Penrose Project
	http://openjdk.java.net/projects/penrose/
Modularity - what is it ?
	http://www.infoq.com/articles/modular-java-what-is-it/
Java modularity - why ?
	http://java.dzone.com/articles/java-modularity-2-why
Java JAR hell problem
	http://en.wikipedia.org/wiki/Java_Classloader#JAR_hell
Java Module System Requirements
	http://openjdk.java.net/projects/jigsaw/doc/draft-java-module-system-requirements-12
Project Jigsaw: The Big Picture
	http://cr.openjdk.java.net/~mr/jigsaw/notes/jigsaw-big-picture-01
Java 8 Modules Jigsaw and OSGi
	http://www.slideshare.net/mfrancis/java-8-modules-jigsaw-and-osgi-neil-bartlett
Project Jigsaw: Late for the train
	http://mreinhold.org/blog/late-for-the-train-qa
Unbearable lightness of Jigsaw
	http://blog.osgi.org/2011/05/unbearable-lightness-of-jigsaw.html
Netbeans discussion on Jigsaw
	http://wiki.netbeans.org/Jigsaw
Java Modularity - OSGi and Project Jigsaw
	http://techdistrict.kirkk.com/2009/06/12/java-modularity-osgi-and-project-jigsaw/
The Modular Java Platform & Project Jigsaw
	http://www.jfokus.se/jfokus14/preso/Jigsaw.pdf
JAX 2013: A Project Jigsaw primer
	http://jaxenter.com/a-project-jigsaw-primer-50029.html
JavaOne 2013: The Modular Java Platform and Project Jigsaw
	http://parleys.com/play/52549d02e4b0a43ac12124be/about
OpenJDK Penrose JavaOne 2012
	http://www.slideshare.net/bosschaert/open-jdk-penrose-javaone-2012
