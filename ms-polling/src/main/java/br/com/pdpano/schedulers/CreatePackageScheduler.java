package br.com.pdpano.schedulers;

import br.com.pdpano.services.PackageService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CreatePackageScheduler {

    private final PackageService packageService;

    public CreatePackageScheduler(PackageService packageService) {
        this.packageService = packageService;
    }

    @Scheduled(fixedDelay = 1000L)
    private void process() {
        packageService.createPackage();
    }

}
