package com.tomek.service;

import com.tomek.domain.Writer;
import com.tomek.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService {

    private WriterRepository writerRepository;

    @Autowired
    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public Writer writerByName(String name){
        return writerRepository.findByFirstName(name);
    }
}
