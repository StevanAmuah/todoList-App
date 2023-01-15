package com.amuah.todolist.dataModel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TodoData {
    private static TodoData instance;
    private static String filename = "TodoListItems.txt";

    private List<TodoItem> todoItems;
    private DateTimeFormatter formatter;


    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    }

    public static TodoData getInstance() {
        if (instance == null) {
            instance = new TodoData();
        }
        return instance;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];
                LocalDate date = LocalDate.parse(dateString, formatter);

                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);


            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);


    }
}
