package com.mf.spi.service;

public interface BootService {

    void prepare();

    void boot();

    void onComplete();

    void shutDown();

    default int priority() { return  0;}
}
