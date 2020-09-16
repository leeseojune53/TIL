import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PokeBag {
    private final HashMap<String, ArrayList<Pokemon>> pokemons = new HashMap<>();

    public ArrayList<Pokemon> getPokemons(String name) {
        return pokemons.get(name);
    }

    public void add(Pokemon pokemon) {
        String name = pokemon.name;

        if(getPokemons(name) == null){
            ArrayList<Pokemon> arrayList = new ArrayList<>();
            pokemons.put(name,arrayList);
        }
        getPokemons(name).add(pokemon);
    }

    public Pokemon getStrongest(String name) {
        ArrayList<Pokemon> Pokelist = getPokemons(name);
        if(Pokelist == null){
            return null;
        }
        Pokemon Strong = null;

        for(Pokemon Pok:Pokelist){
            if(Strong == null || Pok.cp > Strong.cp){
                Strong = Pok;
            }
        }
        return Strong;
    }

    public Pokemon getStrongest() {
        Pokemon Strong = null;

        for(String Key:pokemons.keySet()){
            Pokemon p = getStrongest(Key);
            if(Strong == null || p.cp > Strong.cp){
                Strong = p;
            }
        }
        return Strong;
    }
}