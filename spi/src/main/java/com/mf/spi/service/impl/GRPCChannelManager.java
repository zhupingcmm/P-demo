package com.mf.spi.service.impl;

import com.mf.spi.listener.GRPCChannelListener;
import com.mf.spi.listener.GRPCChannelStatus;
import com.mf.spi.service.BootService;

import java.util.ArrayList;
import java.util.List;

public class GRPCChannelManager implements BootService {

    private List<GRPCChannelListener> listeners = new ArrayList<>();
    @Override
    public void prepare() {
        System.out.println("GRPCChannelManager prepare");



    }

    @Override
    public void boot() {

    }

    @Override
    public void onComplete() {
        System.out.println("GRPCChannelManager onComplete");
        notify(GRPCChannelStatus.CONNECTED);
    }

    @Override
    public void shutDown() {

    }

    @Override
    public int priority() {
        return 10;
    }


    private void notify (GRPCChannelStatus status) {
        listeners.forEach(listener -> {
            listener.statusChanged(status);
        });
    }


    public void addlistener( GRPCChannelListener listener) {
        listeners.add(listener);
    }
}
