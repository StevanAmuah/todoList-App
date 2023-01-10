package com.amuah.todolist;

import com.amuah.todolist.dataModel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private ListView<TodoItem> todoListView;


    public void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John", LocalDate.of(2016, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Doctor's Appointment", "See the Doctor Stephen at Takoradi Hosiptal", LocalDate.of(2016, Month.MAY, 23));
        TodoItem item3 = new TodoItem("Finish design proposal for client", "I promised David I will email websites mockups by Friday 22nd April", LocalDate.of(2016, Month.APRIL, 22));
        TodoItem item4 = new TodoItem("Pickup Sister at the bus station", "Sister is arriving with the last bus", LocalDate.of(2016, Month.APRIL, 23));
        TodoItem item5 = new TodoItem("Buy foodstuffs for the market", "Cooking should be done early enough", LocalDate.of(2016, Month.APRIL, 20));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(sb.toString());


        //System.out.println("The selected item is " + item);


    }
}