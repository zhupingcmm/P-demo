package com.mf.spi.listener;

public interface GRPCChannelListener {
    void statusChanged(GRPCChannelStatus status);
}
