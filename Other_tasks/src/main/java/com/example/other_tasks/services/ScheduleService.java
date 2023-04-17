package com.example.other_tasks.services;

import com.example.other_tasks.models.Bank;
import com.example.other_tasks.models.Card;
import com.example.other_tasks.repositories.BankRepository;
import com.example.other_tasks.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@ManagedResource(objectName = "bean:name=ScheduleService")
@Service
@EnableScheduling
@RequiredArgsConstructor
public class ScheduleService {

    private final CardRepository cardRepository;
    private final BankRepository bankRepository;

    @Scheduled(fixedRate = 1800000)
    public void updateData() throws IOException {
        File dir = new File("D:\\Programming\\Java\\Tasks_Mirea\\Other_tasks\\src\\main\\resources\\entityData");
        FileUtils.cleanDirectory(dir);
        List<Card> cards = cardRepository.findAll();
        List<Bank> banks = bankRepository.findAll();
        createFileForEntity(dir, cards, "cards");
        createFileForEntity(dir, banks, "banks");
    }

    @ManagedOperation()
    public void updateDataJmx() throws IOException {
        updateData();
    }

    private <E> void createFileForEntity(File dir, List<E> entities, String nameClass) throws IOException {
        File file = new File(dir + "\\" + nameClass + ".txt");
        FileWriter writer = new FileWriter(file);
        for (E entity : entities) {
            writer.write(entity.toString()+"\n");
        }
        writer.close();
    }
}
