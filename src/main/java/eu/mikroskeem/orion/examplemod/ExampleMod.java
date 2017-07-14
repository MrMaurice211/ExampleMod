package eu.mikroskeem.orion.examplemod;

import com.google.common.eventbus.Subscribe;
import eu.mikroskeem.orion.api.Orion;
import eu.mikroskeem.orion.api.annotations.OrionMod;
import eu.mikroskeem.orion.api.events.ModConstructEvent;
import eu.mikroskeem.orion.api.events.ModLoadEvent;
import eu.mikroskeem.shuriken.common.streams.ByteArrays;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


/**
 * Orion example mod
 *
 * @author Mark Vainomaa
 */
@OrionMod(id = "examplemod")
public final class ExampleMod {
    @Inject private Logger logger;
    @Inject private Orion orion;
    @Inject @Named("configurationPath") private Path configurationPath;
    @Inject private ConfigurationLoader<CommentedConfigurationNode> configurationLoader;
    private boolean restoreCheck = false;

    @Subscribe
    public void on(ModConstructEvent e) throws Exception {
        logger.info("Hello world!");
        if(Files.notExists(configurationPath)) {
            Files.write(
                    configurationPath,
                    ByteArrays.fromInputStream(
                            ExampleMod.class.getResourceAsStream("/assets/examplemod/examplemod.cfg")),
                    StandardOpenOption.CREATE_NEW,
                    StandardOpenOption.WRITE
            );
        }
        CommentedConfigurationNode baseNode = configurationLoader.load();
        restoreCheck = baseNode.getNode("restore-the-check").getBoolean(false);
        configurationLoader.save(baseNode);
    }

    @Subscribe
    public void on(ModLoadEvent e) throws Exception {
        if(restoreCheck) {
            logger.info("Not applying EULA remover mixin, as user requested not to do so.");
            return;
        }
        orion.registerMixinConfig("mixins.examplemod.json");
    }
}
