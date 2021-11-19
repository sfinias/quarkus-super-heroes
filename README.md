<header>Quarkus SuperHeroes App</header>

As followed from https://quarkus.io/quarkus-workshops/super-heroes/

Notes
<li>Run with given profile <code>./mvnw quarkus:{prof}</code>, e.g. <code>./mvnw quarkus:dev</code></li>
<li>Build native app <code>./mvnw package -Pnative</code></li>
<li>Add profile specific property <code>%{prof}.</code>, e.g. <code>%test.level.multiplier=1</code></li>
<li>Build a new quarkus app <code>
