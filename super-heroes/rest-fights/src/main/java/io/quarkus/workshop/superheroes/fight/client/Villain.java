package io.quarkus.workshop.superheroes.fight.client;

import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "The villain fighting against the hero")
public class Villain {

    @NotNull
    public String name;

    @NotNull
    public int level;

    @NotNull
    public String picture;

    public String powers;
}
