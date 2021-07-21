package com.shashanka.controller;

import com.shashanka.service.ImportFileService;
import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@RequestMapping("/import")
@RestController
public class ImportFileController {

    @Autowired
    ImportFileService importFileService;

    @PostMapping
    public ResponseEntity addFile(@RequestParam("file") MultipartFile file) throws IOException {


        String extension = FileNameUtils.getExtension(file.getOriginalFilename());

        if(!(extension.equals("xlsx") || extension.equals("xls")))
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Expecting file of type xls or xlsx got "+extension);

        return importFileService.addFileService(file);

    }
}
