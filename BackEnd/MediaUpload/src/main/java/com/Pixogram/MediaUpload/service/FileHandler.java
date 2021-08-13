package com.Pixogram.MediaUpload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public final class FileHandler {

	public static String saveFile(MultipartFile file ,String userId , String nextMediaNo) throws IOException {
		String folder = "/media/userId_"+userId+"/";
		Files.createDirectories(Paths.get(folder));
		byte[] bytes = file.getBytes();
		Path path = Paths.get(folder + nextMediaNo + "." + file.getOriginalFilename().split("\\.")[1]);
		Files.write(path, bytes);
		return path.toString();

	}
	
}
