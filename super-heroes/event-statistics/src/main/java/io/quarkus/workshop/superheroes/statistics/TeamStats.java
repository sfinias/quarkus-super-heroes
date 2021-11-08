package io.quarkus.workshop.superheroes.statistics;

class TeamStats {

    private int villains;
    private int heroes;

    double add(Fight result) {
        if (result.winnerTeam.equalsIgnoreCase("heroes")) {
            heroes++;
        } else {
            villains++;
        }
        return ((double) heroes / (heroes + villains));
    }

}
