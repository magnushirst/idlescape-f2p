package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import com.idlescape.gamedata.song.Songs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.music.Song;

@Getter
@AllArgsConstructor
public final class SongUnlockedRequirement implements IRequirement {
    private final Song song;

    @Override
    public boolean hasMet() {
        return Songs.isUnlocked(song);
    }
}
