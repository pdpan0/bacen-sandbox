package br.com.pdpano.clients;

import br.com.pdpano.clients.dto.PackageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "packages", url = "${ms-polling.clients.ms-core}")
public interface PackageClient {

    @GetMapping(value = "/api/v1/packages")
    PackageDTO createPackage(PackageDTO packageDTO);

}
