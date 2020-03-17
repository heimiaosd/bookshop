package com.example.demo.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

public class NamingStrategy extends ImplicitNamingStrategyComponentPathImpl {
    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        return super.toIdentifier("rc_"+stringForm, buildingContext);
    }
}
