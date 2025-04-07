package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Folder> filmFolders = List.of(
                new SpecificFolder("Titanic", "SMALL"),
                new SpecificFolder("A Week Away", "MEDIUM")
        );

        FileCabinet fileCabinetFilm = new FileCabinet(filmFolders);
        fileCabinetFilm.findFolderByName("titanic");
        fileCabinetFilm.findFolderByName("A week away");
        fileCabinetFilm.findFolderByName("titanic111");
        fileCabinetFilm.findFoldersBySize("SMALL");


        SpecificMultiFolder photoAlbums = new SpecificMultiFolder(new ArrayList<>());
        photoAlbums.getFolders().add(new SpecificFolder("New York, photos - 1984", "LARGE"));
        photoAlbums.getFolders().add(new SpecificFolder("Photo shoot in Paris", "SMALL"));

        System.out.println(new FileCabinet(photoAlbums.getFolders()).count());

        SpecificMultiFolder travelFolder = new SpecificMultiFolder(new ArrayList<>());
        travelFolder.getFolders().add(new SpecificFolder("Trip to Paris", "MEDIUM"));
        travelFolder.getFolders().add(new SpecificFolder("Journey through Japan", "LARGE"));
        travelFolder.getFolders().add(new SpecificFolder("Journey through Sweden", "LARGE"));
        travelFolder.getFolders().add(new SpecificFolder("Journey through Portugal", "LARGE"));
        travelFolder.getFolders().add(new SpecificFolder("The Alps", "LARGE"));

        FileCabinet travelFileCabinet = new FileCabinet(travelFolder.getFolders());
        travelFileCabinet.findFoldersBySize("LARGE");
        travelFileCabinet.findFolderByName("Trip to Paris");


    }

}