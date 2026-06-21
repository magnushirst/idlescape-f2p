package com.idlescape;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.idlescape.framework.tree.ScriptBranch;
import com.idlescape.scripts.misc.itempicker.ItemPickerScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.frameworks.treebranch.TreeScript;
import org.dreambot.api.utilities.Logger;

@ScriptManifest(
        name = "IdleScape F2P",
        description = "A collection of botting scripts",
        author = "Clutch Iron Men",
        version = 0.1,
        category = Category.MISC,
        image = "https://res.cloudinary.com/dadgivilj/image/upload/v1778573224/idlescape_logo_scriptmanager.png")
public class BotManager extends TreeScript {
    Injector injector;
    BotConfig botConfig;

    @Override
    public void onStart() {
        injector = Guice.createInjector(new BotModule());
        ScriptBranch itemPicker = injector.getInstance(ItemPickerScript.class);
        addBranches(itemPicker);

        botConfig = injector.getInstance(BotConfig.class);
    }

    @Override
    public int onLoop() {
        Logger.log(botConfig.getCurrentLeaf());
        return super.onLoop();
    }
}
