package org.ow2.chameleon.fuchsia.core.declaration;

import org.osgi.framework.ServiceReference;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Morgan Martinet
 */
class DeclarationDecorator implements Declaration, ImportDeclaration, ExportDeclaration {

    private final Declaration declaration;

    // The extra-metadata of the Declaration, set by the ImportationLinker
    private final Map<String, Object> extraMetadata;

    DeclarationDecorator(Declaration declaration, Map<String, Object> extraMetadata) {
        if (declaration == null) {
            throw new IllegalArgumentException("Cannot decorate a null object");
        }

        this.declaration = declaration;
        if (extraMetadata == null) {
            this.extraMetadata = Collections.unmodifiableMap(new HashMap<String, Object>());
        } else {
            this.extraMetadata = Collections.unmodifiableMap(extraMetadata);
        }
    }

    public Map<String, Object> getMetadata() {
        return declaration.getMetadata();
    }

    public Map<String, Object> getExtraMetadata() {
        // Aggregate the extraMetadata of the decorated object and the extraMetadata of the decorator
        Map<String, Object> em = new HashMap<String, Object>(declaration.getExtraMetadata());
        em.putAll(this.extraMetadata);
        return Collections.unmodifiableMap(em);
    }

    public Status getStatus() {
        return declaration.getStatus();
    }

    public void bind(ServiceReference serviceReference) {
        declaration.bind(serviceReference);
    }

    public void unbind(ServiceReference serviceReference) {
        declaration.unbind(serviceReference);
    }

    public void handle(ServiceReference serviceReference) {
        declaration.handle(serviceReference);
    }

    public void unhandle(ServiceReference serviceReference) {
        declaration.unhandle(serviceReference);
    }

    public String toString() {
        Status status = declaration.getStatus();
        return String.format("[Declaration:%s(%s)(%d(%d))]",
                getMetadata().toString(), getExtraMetadata().toString(),
                status.getServiceReferencesBounded().size(), status.getServiceReferencesHandled().size());
    }

}
