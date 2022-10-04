package com.searching.academy.controller;

import com.searching.academy.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final UploadService uploadService;

    @GetMapping(produces = {"image/png", "image/jpeg", "image/gif"})
    public ResponseEntity<byte[]> open(@RequestParam("path") String path){
        return ResponseEntity.ok()
                .body(uploadService.getResource(path));
    }

    @GetMapping(value = "/download", produces = {"image/png", "image/jpeg", "image/gif"})
    public ResponseEntity<byte[]> download(@RequestParam("path") String path){
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/png", "image/jpeg", "image/gif")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(uploadService.getResource(path));
    }

}
