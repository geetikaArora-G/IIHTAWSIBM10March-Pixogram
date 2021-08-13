package com.Pixogram.UserManagement.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public final class FileHandler {

	public static String saveFile(MultipartFile file ,String userName) throws IOException {
		String folder = "/photos/";
		byte[] bytes = file.getBytes();
		Path path = Paths.get(folder + userName + "." + file.getOriginalFilename().split("\\.")[1]);
		Files.write(path, bytes);
		return path.toString();

	}
	

}
