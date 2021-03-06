package org.ow2.chameleon.fuchsia.upnp.examples.config;

import org.apache.felix.ipojo.configuration.Configuration;
import org.apache.felix.ipojo.configuration.Instance;

import static org.apache.felix.ipojo.configuration.Instance.instance;
import static org.ow2.chameleon.fuchsia.core.component.ImportationLinker.FILTER_IMPORTERSERVICE_PROPERTY;

@Configuration
public class DiscoveryInitializer {

    Instance upnpDiscovery = instance()
            .of("org.ow2.chameleon.fuchsia.discovery.upnp.UPnPDiscovery")
            .named("Fuchsia-UPnPDiscovery")
            .with(FILTER_IMPORTERSERVICE_PROPERTY).setto("(instance.name=FuchsiaUPnPImporter)")
            .with("target").setto("(id=*)");


}
