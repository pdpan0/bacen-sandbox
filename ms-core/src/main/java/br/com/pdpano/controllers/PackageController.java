package br.com.pdpano.controllers;

import br.com.pdpano.dtos.CreatePackageDTO;
import br.com.pdpano.entities.PackageEntity;
import br.com.pdpano.services.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@SuppressWarnings("unused")
@RequestMapping("v1/packages")
@RestController
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping
    public ResponseEntity<PackageEntity> create(@RequestBody CreatePackageDTO packageDTO) {
        return ResponseEntity // todo: sending unecessary binary
                .created(URI.create(packageService.createPackage(packageDTO.toPackage()).getCode()))
                .build();
    }

    @GetMapping("{code}")
    public ResponseEntity<PackageEntity> getPackageByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(packageService.getPackage(code));
    }
}
