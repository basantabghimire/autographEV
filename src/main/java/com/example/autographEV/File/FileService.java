package com.example.autographEV.File;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public boolean upload(MultipartFile file) {
        //System.out.format("Uploading %s to S3 bucket %s...\n", file_path, bucket_name);
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA4N3DTLCHVZ7HOC6S","3YwdDNwPaFlRHcUE8b+Ox5FcG/n6Hxo5G0a3yAfB");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();

        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            s3.putObject("basantabg", file.getOriginalFilename(), file.getInputStream(), metadata);
            return true;

        } catch (AmazonServiceException | IOException e) {
           /* System.err.println(e.getErrorMessage());
            System.exit(1);*/
            //System.out.println(e.printStackTrace());
            e.printStackTrace();
            return false;
        }
    }
    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA4N3DTLCHVZ7HOC6S","3YwdDNwPaFlRHcUE8b+Ox5FcG/n6Hxo5G0a3yAfB");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();
        return s3.getObject("basantabg",key);
    }

    public void deleteFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA4N3DTLCHVZ7HOC6S","3YwdDNwPaFlRHcUE8b+Ox5FcG/n6Hxo5G0a3yAfB");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();
        s3.deleteObject("basantabg",key);
    }
}
