package com.crio.jukebox.Services;

import java.util.List;
import java.util.Optional;
import com.crio.jukebox.entities.Album;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exceptions.SongNotFoundException;

public interface ISongService {

    public void addSong(Song song);
    public Optional<Song> getSong(String songId);
    public List<Song> getAllSongs();
    public List<Song> getSongsByAlbum(Album album);
    public Song removeSong(String songId) throws SongNotFoundException;
    public Song getSongById(String songId);
  
    
    
    
}
