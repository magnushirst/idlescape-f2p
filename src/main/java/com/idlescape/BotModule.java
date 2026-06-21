package com.idlescape;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public final class BotModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BotConfig.class).in(Scopes.SINGLETON);
    }
}
