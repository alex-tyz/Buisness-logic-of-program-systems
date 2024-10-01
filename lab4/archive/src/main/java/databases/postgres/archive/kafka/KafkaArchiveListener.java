package databases.postgres.archive.kafka;

import databases.postgres.archive.service.ArchiveService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class KafkaArchiveListener {
    private static final Logger log = LogManager.getLogger(KafkaArchiveListener.class);

    @Autowired
    private ArchiveService archiveService;

    @Transactional(transactionManager = "jdbcTransactionManager")
    @KafkaListener(topics = "archive", groupId = "group2")
    void listenerArchive(String data) {
        log.info("Received message [{}] in group2", data);
        archiveService.setTicket(data);
    }
}
