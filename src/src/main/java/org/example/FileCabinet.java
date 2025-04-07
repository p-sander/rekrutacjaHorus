package org.example;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Log4j2
public class FileCabinet implements Cabinet {
    private List<Folder> folders;

    @Override
    public Optional<Folder> findFolderByName(String name) {

        for (Folder folder : checkForNestedFoldersAndReturnFullList()) {
            if (folder.getName().equals(name)) {
                log.info("Operation 'find folder by name' is successful. Found ---> " + name);
                return Optional.of(folder);
            }
        }
        log.info("No folder with given name " + name);
        return Optional.empty();
    }



    //options small medium large btw this could be an enum ;)
    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> foldersWithMatchingSize = new ArrayList<>();
        for (Folder folder : checkForNestedFoldersAndReturnFullList())
            if (folder.getSize().equals(size)) {
               foldersWithMatchingSize.add(folder);
                log.info("Found folder in searched size: " + size + " Found ---> " + folder.getName());
            }
        return foldersWithMatchingSize;
    }

    @Override
    public int count() {
      return checkForNestedFoldersAndReturnFullList().size();
    }

    private List<Folder> checkForNestedFoldersAndReturnFullList() {
        List<Folder> givenFolders = new ArrayList<>(folders);
        List<Folder> fullListOfFolders = new ArrayList<>(folders);

        for (Folder maybeMultiFolder : givenFolders) {
            if (maybeMultiFolder instanceof MultiFolder) {
                fullListOfFolders.addAll(((MultiFolder) maybeMultiFolder).getFolders());
            }
        }
        return fullListOfFolders;
    }
}