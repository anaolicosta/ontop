package org.semanticweb.ontop.pivotalrepr.impl;

import com.google.common.base.Optional;
import org.semanticweb.ontop.model.DataAtom;
import org.semanticweb.ontop.pivotalrepr.*;
import org.semanticweb.ontop.pivotalrepr.proposal.LocalOptimizationProposal;

public class OrdinaryDataNodeImpl extends DataNodeImpl implements OrdinaryDataNode {

    private static final String ORDINARY_DATA_NODE_STR = "DATA";

    public OrdinaryDataNodeImpl(DataAtom atom) {
        super(atom);
    }

    @Override
    public Optional<LocalOptimizationProposal> acceptOptimizer(QueryNodeOptimizer optimizer) {
        return optimizer.makeProposal(this);
    }

    @Override
    public void acceptVisitor(QueryNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OrdinaryDataNode clone() {
        return new OrdinaryDataNodeImpl(getAtom());
    }

    @Override
    public OrdinaryDataNode acceptNodeTransformer(QueryNodeTransformer transformer) throws QueryNodeTransformationException {
        return transformer.transform(this);
    }

    @Override
    public String toString() {
        return ORDINARY_DATA_NODE_STR + " " + getAtom();
    }
}
