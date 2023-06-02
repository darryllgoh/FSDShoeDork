package org.generation.FSDShoeDork.component;

import java.io.*;
import java.nio.file.*;

/*
 * Azure Blob Storage quickstart
 */
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {


    public static void saveFile(String uploadDir1, String fileName,
                                MultipartFile multipartFile) throws IOException
    {
//        Path uploadPath1 = Paths.get(uploadDir1);
//        try (InputStream inputStream = multipartFile.getInputStream()) {
//
//
//            Path filePath1 = uploadPath1.resolve(fileName);
//            Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ioe) {
//            throw new IOException("Could not save image file: " + fileName, ioe);
//        }

        //upload to Azure
        /* This is the setup using Azure storage */
        String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=shoedorkproductimage;AccountKey=o6UrXDaUhTYc2auE+3XVpWejuOGb/yc9GWU7k/E1hG6KtlELH/lx7aIb2yneOff22eq/dKaTVbLs+AStmhDxPQ==;EndpointSuffix=core.windows.net";
        //create a connection between the web app and storage container created in Azure server
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();

        //specify which container we want to get the images from
        String containerName = "prodimage";

        //to get the container with images
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        //fileName refers to which image filename that we want to upload (e.g. t-shirt_new.jpg)
        BlobClient blobClient = containerClient.getBlobClient(fileName);
        InputStream inputStream = multipartFile.getInputStream();
        blobClient.upload(inputStream);


    }
}
