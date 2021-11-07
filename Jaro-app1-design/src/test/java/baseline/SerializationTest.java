/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class SerializationTest {

    @Test
    void save_list_creates_save_file() {
        //make new Serialization instance
        Serialization myPath = new Serialization();

        //make new list that will be saved
        List<Item> toSave = new ArrayList<>();

        //fill List with an Item
        toSave.add(new Item("one", new CreateDate(), false));

        //make a testFile
        File testFile = new File("src/test/resources/test1.json");

        //call saveList method with testFile path and list toSave
        myPath.saveList(testFile.getPath(), toSave);

        //assert the file exists
        assert(testFile.exists());
    }

    @Test
    void save_list_saves_content_description() {
        //make new Serialization instance
        Serialization myPath = new Serialization();

        //make new list that will be saved
        List<Item> toSave = new ArrayList<>();

        //fill List with an Item
        Item item = new Item("one", new CreateDate(), true);
        toSave.add(item);

        //make a testFile
        File testFile = new File("src/test/resources/test2.json");

        //call saveList method with testFile path and list toSave
        myPath.saveList(testFile.getPath(), toSave);

        //load the file in with loadJson()
        List<Item> loadList = myPath.loadJson(testFile.getPath());

        //assert content is the same
        assertEquals("one", loadList.get(0).getDescription());
    }

    @Test
    void save_list_saves_content_date() {
        //make new Serialization instance
        Serialization myPath = new Serialization();
        //make new list that will be saved
        List<Item> toSave = new ArrayList<>();
        //fill List with an Item
        Item item = new Item("one", new CreateDate(), true);
        toSave.add(item);
        //make a testFile
        File testFile = new File("src/test/resources/test2.json");

        //call saveList method with testFile path and list toSave
        myPath.saveList(testFile.getPath(), toSave);

        //load the file in with loadJson()
        List<Item> loadList = myPath.loadJson(testFile.getPath());

        //assert content is the same
        assertEquals("2000-01-01", loadList.get(0).getDueDateString());
    }

    @Test
    void saveListsavesContent() {
        //make new Serialization instance
        Serialization myPath = new Serialization();
        //make new list that will be saved
        List<Item> toSave = new ArrayList<>();
        //fill List with an Item
        Item item = new Item("one", new CreateDate(), true);
        toSave.add(item);
        //make a testFile
        File testFile = new File("src/test/resources/test2.json");
        //call saveList method with testFile path and list toSave
        myPath.saveList(testFile.getPath(), toSave);
        //load the file in with loadJson()
        List<Item> loadList = myPath.loadJson(testFile.getPath());
        //assert content is the same
        assertTrue(loadList.get(0).getIsComplete());
    }
}