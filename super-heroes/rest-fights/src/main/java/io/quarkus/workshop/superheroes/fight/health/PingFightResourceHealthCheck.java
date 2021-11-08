package io.quarkus.workshop.superheroes.fight.health;

import io.quarkus.workshop.superheroes.fight.FightResource;
import javax.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

public class PingFightResourceHealthCheck implements HealthCheck {

    @Inject
    FightResource fightResource;

    @Override
    public HealthCheckResponse call() {

        String response = fightResource.hello();
        return HealthCheckResponse.named("Pind Fights REST Endpoint").withData("Response", response).up().build();
    }
}
