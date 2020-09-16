public class Song {
    private String songname;
    private Artist Artistname;
    private Album Albumname;

    Song(String songname, Artist Artistname, Album Albumname){
        this.songname = songname;
        this.Artistname = Artistname;
        this.Albumname = Albumname;
    }

    public String getSongname() {
        return songname;
    }

}
