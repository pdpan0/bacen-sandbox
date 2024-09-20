package br.com.pdpano.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "tb_packages")
public class PackageEntity {

    @Id
    @GeneratedValue
    private final Long id;
    @Column
    private final String code;
    @Column
    private final String binary;

    public PackageEntity(Long id, String code, String binary) {
        this.id = id;
        this.code = code;
        this.binary = binary;
    }
}
