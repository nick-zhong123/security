package com.nick.security.controller;

import com.nick.security.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author weizhong
 * @date 2020/3/26 9:47 AM
 * @package com.nick.security.controller
 * @description
 */
@Slf4j
@RestController
@RequestMapping("file")
public class FileController {

//    private String fileFolder = "../data";
    private String fileFolder = "/Users/weizhong/work/code/java/nick-security/security-demo/data";

    @PostMapping
    public FileInfo uploadFile(MultipartFile file) throws Exception {
        log.info("fileName:{}, originFileName:{}, Size:{}", file.getName(), file.getOriginalFilename(), file.getSize());
        File localFile = new File(fileFolder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);
        return FileInfo.builder().pathInfo(localFile.getAbsolutePath()).build();
    }

    @GetMapping("{id}")
    public void download(@PathVariable String id,
                         HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws IOException {
        log.info("FileName Id:{}", id);
        try (InputStream inputStream = new FileInputStream(new File(fileFolder,id + ".txt"));
             OutputStream outputStream = httpServletResponse.getOutputStream()) {
            httpServletResponse.setContentType("application/x-download");
            httpServletResponse.setHeader("Content-Disposition", "attachment;filename=text.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
