package br.com.pdpano.schedulers;

import br.com.pdpano.clients.MessageClient;
import br.com.pdpano.clients.PackageClient;
import br.com.pdpano.clients.dto.MessageDTO;
import br.com.pdpano.clients.dto.PackageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class CreatePackageScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreatePackageScheduler.class);
    private final MessageClient messageClient;
    private final PackageClient packageClient;

    public CreatePackageScheduler(MessageClient messageClient,
                                  PackageClient packageClient) {
        this.messageClient = messageClient;
        this.packageClient = packageClient;
    }

    @Scheduled(fixedDelayString = "${ms-polling.package-scheduler.delay}")
    private void process() {
        LOGGER.info("Starting the create package scheduler");
        final List<MessageDTO> messages = getMessages();

        if (messages.isEmpty()) {
            LOGGER.info("Messages are emtpy");
            return;
        }

        sendPackage(createPackage(messages));
    }

    private List<MessageDTO> getMessages() {
        return log(messageClient.getMessages(), "Messages returned by ms-core: {}");
    }

    private void sendPackage(PackageDTO packageDTO) {
        LOGGER.info("Send package to ms-core: {}", packageDTO);
        packageClient.createPackage(packageDTO);
    }

    private PackageDTO createPackage(List<MessageDTO> messages) {
        return log(
                PackageDTO.build(processXmlMessages(messages.stream().map(MessageDTO::message).toList())),
                "Creating package by messages: {}"
        );
    }

    public byte[] processXmlMessages(List<String> xmlMessages) {
        return convertToByteArray(concatenateMessages(xmlMessages));
    }

    private String concatenateMessages(List<String> xmlMessages) {
        return String.join("-------", xmlMessages);
    }

    private byte[] convertToByteArray(String message) {
        return message.getBytes(StandardCharsets.UTF_8);
    }

    private <T> T log(T object, String message) {
        LOGGER.info(message, object);
        return object;
    }
}
