package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.music.Song;
import org.dreambot.framework.requirements.IRequirement;
import org.dreambot.gamedata.song.Songs;

@Getter
@AllArgsConstructor
public final class SongUnlockedRequirement implements IRequirement {
    private final Song song;

    @Override
    public boolean hasMet() {
        return Songs.isUnlocked(song);
    }
}
