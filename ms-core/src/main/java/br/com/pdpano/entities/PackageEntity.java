package br.com.pdpano.entities;

import jakarta.persistence.*;

@Entity(name = "tb_packages")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    @Column
    private String binary;

    public PackageEntity() { }

    public PackageEntity(String code, String binary) {
        this.code = code;
        this.binary = binary;
    }

    public String getCode() {
        return code;
    }

    public String getBinary() {
        return binary;
    }
}
