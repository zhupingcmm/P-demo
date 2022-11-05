package com.mf.spi;

import com.mf.spi.service.BootService;

import java.util.*;

public enum ServiceManager {

    INSTANCE;

    private Map<Class<?>, BootService> bootedServices = new HashMap<>();

    public void boot () {
        loadAllServices();
        prepare();
        onComplete();

    }

    private void loadAllServices() {
        List<BootService> services = new ArrayList<>();
        for (BootService service: ServiceLoader.load(BootService.class)) {
            services.add(service);
        }

        services.forEach(service -> bootedServices.put(service.getClass(), service));
    }

    private void prepare() {
        bootedServices.values().forEach(bootService -> {
            bootService.prepare();
        });
    }

    private void onComplete() {
        bootedServices.values().forEach(bootService -> {
            bootService.onComplete();
        });
    }


    public <T extends  BootService> T findService(Class<T> serviceClass) {
       return (T) bootedServices.get(serviceClass);
    }
}
