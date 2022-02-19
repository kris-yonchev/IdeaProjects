package DefiningClassesExercise.Google;

import java.util.List;

public class Person {
    private String name;
    private List<Pokemon> pokemonList;
    private List<Parents> parentList;
    private List<Kids> childList;
    private Car car;
    private Company company;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Person(String name, List<Pokemon> pokemonList, List<Parents> parentList, List<Kids> childList) {
        this.name = name;
        this.pokemonList = pokemonList;
        this.parentList = parentList;
        this.childList = childList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParentList() {
        return parentList;
    }

    public List<Kids> getChildList() {
        return childList;
    }

    public void printFormat() {
        System.out.println(name);
        System.out.println("Company:");
        if (company != null) {
            System.out.println(company.format());
        }
        System.out.println("Car:");
        if (car != null) {
            System.out.println(car.format());
        }
        System.out.println("Pokemon:");
        if (!getPokemonList().isEmpty()) {
            getPokemonList().forEach(p -> System.out.printf("%s\n", p.format()));
        }
        System.out.println("Parents:");
        if (!getParentList().isEmpty()) {
            getParentList().forEach(p -> System.out.printf("%s\n", p.format()));
        }
        System.out.println("Children:");
        if (!getChildList().isEmpty()) {
            getChildList().forEach(c -> System.out.printf("%s\n", c.format()));
        }
    }
}
