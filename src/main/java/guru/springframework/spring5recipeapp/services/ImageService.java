package guru.springframework.spring5recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 30.11.2021
 */
public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);
}
