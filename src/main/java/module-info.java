module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens todolist to javafx.fxml;
    exports todolist;
    exports todolist.Controllers;
    opens todolist.Controllers to javafx.fxml;
}