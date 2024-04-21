<h2>RegistryAPI</h2>

A api for access registry of minecraft, instead of use datapack.<br>
To use this api, you should install this plugin to the server: https://github.com/Lumine1909/RegistryAPI/releases/latest <br>
Only support minecraft 1.16.5+.
<h3>Usage</h3>
```java
//Biome color: grass #ffffff, foliage #000000
BiomeColor bc = new BiomeColor().setGrassColor(16777215).setFoliageColor(0);
//Create and register
Biome biome = RegistryAPI.Manager.BIOME.createBiome(bc, new ResourceKey("example", "biome1"));
//Change biome of block
RegistryAPI.Manager.BIOME.setBlockBiome(block, biome);
//Send biome change to client (If the biome is created after client connect, this won't work)
RegistryAPI.Manager.BIOME.sendBiomeChange(block);
```
result:

![image](https://github.com/Lumine1909/RegistryAPI/assets/133463833/eb0fb3fe-334d-476e-9812-d6a6fe096c0c)

For more details: see "example-plugin".<br>
This project is still developing so may be unstable.<br>
If any problems happens during use, please feel free to submit Issues.

***next feature: world height and generate***

<br><h3>Dependency:</h3>

<h4>Maven:</h4>
```
<repositories>
  <id>lumine1909</id>
  <url>https://maven.pkg.github.com/Lumine1909/RegistryAPI/registry-api</url>
</repositories>

<dependency>
  <groupId>io.github.lumine1909</groupId>
  <artifactId>registry-api</artifactId>
  <version>alpha-1.1</version>
  <scope>provided</scope>
</dependency>
```

<h4>Gradle:</h4>
```
repositories {
    maven("https://maven.pkg.github.com/Lumine1909/RegistryAPI/registry-api")
}


dependencies {
    compileOnly("io.github.lumine1909:registry-api:alpha-1.1")
}
```