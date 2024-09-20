package br.com.pdpano.repositories;

import br.com.pdpano.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, String> {}
