package org.dreambot.gamedata.song;

import org.dreambot.api.methods.music.Song;

public class Songs {
    public static boolean isUnlocked(Song song){
        return song.isUnlocked();
    }
}
