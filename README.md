<header>Quarkus SuperHeroes App</header>

Notes
<li>Run with given profile <code>./mvnw quarkus:{prof}</code>, e.g. <code>./mvnw quarkus:dev</code></li>
<li>Build native app <code>./mvnw package -Pnative</code></li>
<li>Add profile specific property <code>%{prof}.</code>, e.g. <code>%test.level.multiplier=1</code></li>
<li>Build a new quarkus app <code>
mvn io.quarkus:quarkus-maven-plugin:2.3.0.Final:create \ <br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;-DprojectGroupId=io.quarkus.workshop.super-heroes \ <br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;-DprojectArtifactId=rest-heroes \<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;-DclassName="io.quarkus.workshop.superheroes.hero.HeroResource" \<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;-Dpath="api/heroes" \<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;-Dextensions="resteasy-reactive-jackson,quarkus-hibernate-validator,quarkus-smallrye-openapi,quarkus-hibernate-reactive-panache,quarkus-reactive-pg-client"</code></li>

