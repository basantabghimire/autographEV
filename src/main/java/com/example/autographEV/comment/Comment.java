package com.example.autographEV.comment;

import com.example.autographEV.Validator.ValidName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="comment")

public class Comment {
    @Id
    private String commentId;
    private String photoId;
    @Length(min = 5)
    private String message;
    @ValidName
    private String createdBy;

    //private String dateCreated;

    @CreatedDate
    private Date dateCreated = new Date(System.currentTimeMillis());
}
