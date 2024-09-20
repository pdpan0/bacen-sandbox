package br.com.pdpano.services;

import br.com.pdpano.entities.PackageEntity;
import br.com.pdpano.exceptions.NotFoundException;
import br.com.pdpano.repositories.PackageRepository;
import org.springframework.stereotype.Service;

@Service
public class PackageService {
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public PackageEntity createPackage(PackageEntity packageEntity) {
        if (packageEntity.getBinary().isBlank()) {
            throw new IllegalArgumentException("package should have binary file");
        }
        return packageRepository.save(packageEntity);
    }

    public PackageEntity getPackage(String code) {
        return packageRepository.findById(code).orElseThrow(() -> new NotFoundException(code));
    }
}
