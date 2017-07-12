package eu.mikroskeem.orion.examplemod;

import com.google.common.eventbus.Subscribe;
import eu.mikroskeem.orion.api.OrionAPI;
import eu.mikroskeem.orion.api.annotations.OrionMod;
import eu.mikroskeem.orion.api.events.ModConstructEvent;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


/**
 * Orion sample mod
 *
 * @author Mark Vainomaa
 */
@OrionMod(id = "samplemod")
public final class ExampleMod {
    @Inject private Logger logger;

    @Subscribe
    public void on(ModConstructEvent e) throws Exception {
        logger.info("Hello world!");
        OrionAPI.getInstance().registerMixinConfig("mixins.examplemod.json");
    }
}
