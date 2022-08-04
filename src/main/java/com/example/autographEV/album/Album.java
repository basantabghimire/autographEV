package com.example.autographEV.album;

import com.example.autographEV.Validator.ValidName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="album")
public class Album {
    @Id
    private String albumId;
    @Length (max = 10)
    private String name;
    private String coverPicUrl;
    @NotEmpty @ValidName
    private String createdBy;

    //private String dateCreated;

    @CreatedDate
    private Date dateCreated = new Date(System.currentTimeMillis());
}
