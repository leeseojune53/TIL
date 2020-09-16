import java.util.ArrayList;

public class Artist {
    private String name;
    ArrayList<Album> Albumlist = new ArrayList<>();

    Artist(String name){
        this.name = name;
    }

    public void addAlbum(Album album){
        Albumlist.add(album);
    }

    public ArrayList<Album> getAlbums(){
        return Albumlist;
    }

    public String getName() {
        return name;
    }
}
