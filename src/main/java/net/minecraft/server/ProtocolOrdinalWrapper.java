package net.minecraft.server;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;

// CraftBukkit - import package private class
class ProtocolOrdinalWrapper {

    static final int[] a = new int[EnumProtocol.values().length];

    static {
        try {
            a[EnumProtocol.LOGIN.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror) {
            ;
        }

        try {
            a[EnumProtocol.STATUS.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror1) {
            ;
        }
    }
}
