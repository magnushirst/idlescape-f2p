package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.music.Song;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class SongUnlockedRequirement implements IRequirement {
    private final Song song;

    @Override
    public boolean hasMet() {
        return song.isUnlocked();
    }
}
