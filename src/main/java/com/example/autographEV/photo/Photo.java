package com.example.autographEV.photo;

import com.example.autographEV.Validator.ValidName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="photo")
public class Photo {
    @Id
    private String photoId;
    private String albumId;
    private String photoUrl;
    @NotEmpty @ValidName
    private String createdBy;

    //private String dateCreated;

    @CreatedDate
    private Date dateCreated = new Date(System.currentTimeMillis());

}
