package net.skhu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String fileName;
    int size;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date modifiedDate;
    String state;
    
    @ManyToOne
    @JoinColumn(name = "folderId")
    Folder folder;

    
}

