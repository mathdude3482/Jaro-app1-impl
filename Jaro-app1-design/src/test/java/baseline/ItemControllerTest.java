/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
class ItemControllerTest {
    @Test
    void get_complete_list_returns_list_of_completed_items() {
        //make new ItemController
        ItemController newControl = new ItemController();
        //add 5 new Items to ItemController allList
        newControl.addItem();
        Item two = newControl.addItem();
        Item three = newControl.addItem();
        newControl.addItem();
        newControl.addItem();
        //make Item 2 and Item 3 isComplete true
        newControl.editComplete(two);
        newControl.editComplete(three);
        //call getCompleteList
        List<Item> completeList = newControl.getCompleteList();

        //make an expected list
        List<Item> expected = new ArrayList<>();
        expected.add(two);
        expected.add(three);

        //Assert expected equals completeList
        assertEquals(expected, completeList);
    }

    @Test
    void get_incomplete_list_returns_list_of_incomplete_items() {
        //make new ItemController
        ItemController myController = new ItemController();

        //add 5 new Items (Item 1, Item 2... Item 5) to ItemController allList
        Item one = myController.addItem();
        Item two = myController.addItem();
        Item three = myController.addItem();
        Item four = myController.addItem();
        Item five = myController.addItem();
        //make Item two and three true
        myController.editComplete(two);
        myController.editComplete(three);
        //call getIncompleteList()
        List<Item> incompleteList = myController.getIncompleteList();
        //make an expected list
        List<Item> expected = new ArrayList<>();
        expected.add(one);
        expected.add(four);
        expected.add(five);
        //Asserted expected equals incompleteList
        assertEquals(expected, incompleteList);
    }

    @Test
    void add_item_adds_item_object_to_all_list() {
        //make new ItemController
        ItemController ic = new ItemController();

        //call addItem() 5 times
        ic.addItem();
        ic.addItem();
        ic.addItem();
        ic.addItem();
        ic.addItem();

        //Assert that allList size is equal to 5
        assertEquals(5, ic.getAllList().size());
    }

    @Test
    void remove_item_removes_item_object_from_all_list() {
        //make new ItemController
        ItemController ic = new ItemController();

        //call addItem() 5 times
        ic.addItem();
        ic.addItem();
        Item toRemove = ic.addItem();
        ic.addItem();
        ic.addItem();

        //call removeItem() with parameter toRemove
        ic.removeItem(toRemove);

        //Assert that allList size is equal to 4
        assertEquals(4, ic.getAllList().size());
    }

    @Test
    void clear_list_clears_all_item_objects_from_all_list() {
        //make new ItemController
        ItemController ic = new ItemController();

        //add 5 new Item objects to allList
        ic.addItem();
        ic.addItem();
        ic.addItem();
        ic.addItem();
        ic.addItem();

        //call clearList()
        ic.clearList();

        //Assert allList is size 0
        assertEquals(0, ic.getAllList().size());
    }

    @Test
    void test_change_description() {
        ItemController myController = new ItemController();
        Item changeItem =myController.addItem();
        myController.changeDescription("different", changeItem);
        String actual = myController.getAllList().get(0).getDescription();
        String expected = "different";
        assertEquals(expected, actual);
    }

    @Test
    void test_change_date() {
        //make new ItemController
        ItemController myController = new ItemController();
        Item changeItem = myController.addItem();
        myController.changeDate("2020-10-10", changeItem);
        String expected = "2020-10-10";
        String actual = myController.getAllList().get(0).getDueDateString();
        //Assert expected and actual are the same
        assertEquals(expected, actual);
    }

    @Test
    void edit_complete_changes_value_of_corresponding_boolean() {
        //make new ItemController
        ItemController itemController = new ItemController();
        //add 5 new Items to List allList.
        itemController.addItem();
        Item toSwap = itemController.addItem();
        itemController.addItem();
        itemController.addItem();
        itemController.addItem();
        //call editComplete with parameter 1
        itemController.editComplete(toSwap);
        //get isComplete of Item at index 1
        boolean actual = itemController.getAllList().get(1).getIsComplete();
        //Assert that isComplete of Item at index 1 is true
        assertTrue(actual);
    }
}