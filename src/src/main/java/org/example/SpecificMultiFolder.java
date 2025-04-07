package org.example;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SpecificMultiFolder implements MultiFolder{
    private List<Folder> multiFolder;
    @Override
    public List<Folder> getFolders() {
        return multiFolder;
    }
}
