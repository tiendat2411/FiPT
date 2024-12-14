package uit.se121.FiPT.controller;

import com.cloudinary.Cloudinary;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uit.se121.FiPT.service.CloudinaryService;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageUploadController {
    CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        return cloudinaryService.uploadImage(file);
    }
}
