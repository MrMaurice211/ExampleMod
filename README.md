# Orion example Mod

## Description
This is example mod demonstrating configuration API and overriding EULA check on 1.12 Paper server using Mixin

Put this into mods dir, remove eula.txt and see how it works :smile:

## Requirements
- Paper 1.12

## Configuration
See `modconfigs/examplemod.cfg`, it has one option named `restore-the-check`. Setting that to `true` makes mod not apply
mixin to the server

## I want to create mod like this!
Sure, here's appropriate Maven/Gradle configuration

### Maven
```xml
<repositories>
    <repository>
        <id>mikroskeem-repo</id>
        <url>https://repo.wut.ee/repository/mikroskeem-repo/</url>
    </repository>
</repositories>

<dependencies>
    <!-- Note: `./paper j` and `mvn install` in Paper-Server directory -->
    <dependency>
        <groupId>com.destroystokyo.paper</groupId>
        <artifactId>paper</artifactId>
        <version>1.12-R0.1-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>

    <!-- Orion API -->
    <dependency>
        <groupId>eu.mikroskeem</groupId>
        <artifactId>orion.api</artifactId>
        <version>0.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```


### Gradle
```groovy
repositories {
    maven {
        name = 'mikroskeem-repo'
        url = 'https://repo.wut.ee/repository/mikroskeem-repo'
    }
}

dependencies {
    compileOnly group: 'com.destroystokyo.paper', name: 'paper', version: '1.12-R0.1-SNAPSHOT'
    compileOnly group: 'eu.mikroskeem', name: 'orion.api', version: '0.0.1'
}
```


## I want this mod!
See [releases](https://github.com/OrionMinecraft/ExampleMod/releases)

## I want to steal your mod's code!
Go ahead, this mod is [WTFPL](http://www.wtfpl.net/about/)
