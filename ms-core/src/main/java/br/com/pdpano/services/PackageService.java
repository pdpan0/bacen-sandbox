package br.com.pdpano.services;

import br.com.pdpano.entities.MessageEntity;
import br.com.pdpano.entities.PackageEntity;
import br.com.pdpano.repositories.MessageRepository;
import br.com.pdpano.repositories.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PackageService {
    private final MessageRepository messageRepository;
    private final PackageRepository packageRepository;

    public PackageService(MessageRepository messageRepository, PackageRepository packageRepository) {
        this.messageRepository = messageRepository;
        this.packageRepository = packageRepository;
    }

    public void createPackage() {
        final String messages = messageRepository.findAll()
                .stream()
                .map(MessageEntity::getMessageId)
                .collect(Collectors.joining());

        packageRepository.save(new PackageEntity(null, UUID.randomUUID().toString(), messages));
    }
}
