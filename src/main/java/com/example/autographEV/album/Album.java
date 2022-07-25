package com.example.autographEV.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="album")
public class Album {
    @Id
    private String albumId;
    private String name;
    private String coverPicUrl;
    private String createdBy;

    //private String dateCreated;

    @CreatedDate
    private Date dateCreated = new Date(System.currentTimeMillis());
}
