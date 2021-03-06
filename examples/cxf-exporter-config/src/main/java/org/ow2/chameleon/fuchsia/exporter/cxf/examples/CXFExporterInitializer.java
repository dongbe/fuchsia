package org.ow2.chameleon.fuchsia.exporter.cxf.examples;

import org.apache.felix.ipojo.configuration.Configuration;
import org.apache.felix.ipojo.configuration.Instance;
import org.ow2.chameleon.fuchsia.core.component.ExportationLinker;
import org.ow2.chameleon.fuchsia.core.FuchsiaConstants;

import static org.apache.felix.ipojo.configuration.Instance.instance;

@Configuration
public class CXFExporterInitializer {

    Instance cxfexporter = instance()
            .of("org.ow2.chameleon.fuchsia.exporter.jaxws.JAXWSExporter")
            .with("target").setto("(fuchsia.export.cxf.instance=*)");

    Instance cxfexporterlinker = instance()
            .of(FuchsiaConstants.DEFAULT_EXPORTATION_LINKER_FACTORY_NAME)
            .with(ExportationLinker.FILTER_EXPORTDECLARATION_PROPERTY).setto("(fuchsia.export.cxf.instance=*)")
            .with(ExportationLinker.FILTER_EXPORTERSERVICE_PROPERTY).setto("(instance.name=cxfexporter)");


}
