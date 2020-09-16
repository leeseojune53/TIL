import java.util.ArrayList;

public class Album {
    private String Albumname;
    private Artist singer;
    private int year;
    ArrayList<Song> Songlist = new ArrayList<>();

    Album(String Albumname, int year, Artist singer){
        this.Albumname = Albumname;
        this.year = year;
        this.singer = singer;
    }

    public void addTrack(Song song){
        Songlist.add(song);
    }

    public String getTrack(int n){
        Song song;
        song = Songlist.get(n-1);
        return song.getSongname() + " - " + singer.getName() + "\n" + Albumname + "(" + year + ")";
    }

}
