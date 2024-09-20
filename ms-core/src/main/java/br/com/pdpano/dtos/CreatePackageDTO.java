package br.com.pdpano.dtos;

import br.com.pdpano.entities.PackageEntity;

public record CreatePackageDTO(String binary) {

    public PackageEntity toPackage() {
        return new PackageEntity(null, this.binary);
    }

}
