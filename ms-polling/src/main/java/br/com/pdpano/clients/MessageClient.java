package br.com.pdpano.clients;

import br.com.pdpano.clients.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "messages", url = "${ms-polling.clients.ms-core}")
public interface MessageClient {

    @GetMapping(value = "/api/v1/messages")
    List<MessageDTO> getMessages();

}
