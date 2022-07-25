package com.example.autographEV.comment;

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
@Document(collection="comment")

public class Comment {
    @Id
    private String commentId;
    private String photoId;
    private String message;
    private String createdBy;

    //private String dateCreated;

    @CreatedDate
    private Date dateCreated = new Date(System.currentTimeMillis());
}
