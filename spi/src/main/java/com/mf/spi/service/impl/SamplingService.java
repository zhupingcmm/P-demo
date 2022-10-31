package com.mf.spi.service.impl;

import com.mf.spi.ServiceManager;
import com.mf.spi.listener.GRPCChannelListener;
import com.mf.spi.listener.GRPCChannelStatus;
import com.mf.spi.service.BootService;

public class SamplingService implements BootService, GRPCChannelListener {
    @Override
    public void prepare() {
        System.out.println("SamplingService prepare");
        ServiceManager.INSTANCE.findService(GRPCChannelManager.class).addlistener(this);
    }

    @Override
    public void boot() {

    }

    @Override
    public void onComplete() {
        System.out.println("SamplingService onComplete");
    }

    @Override
    public void shutDown() {

    }

    @Override
    public void statusChanged(GRPCChannelStatus status) {
        System.out.println("SamplingService status change " + status);
    }
}
