package Scientific;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static javafx.geometry.Pos.CENTER;
import static javafx.scene.layout.VBoxBuilder.create;

public class Main extends Application {

    final double software_version = 1.21;
    String name1, name2, name3;


    @Override
    public void start(final Stage primaryStage) {

        primaryStage.setTitle("Tool v1.2.1");
        final File saveDir = new File("Beata's tool dir");

        GridPane pane = new GridPane();
        final FileChooser fileChooser = new FileChooser();


        pane.setAlignment(CENTER);

        pane.setVgap(10);
        pane.setHgap(10);

        pane.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(pane, 1000, 700);
        primaryStage.setResizable(false);

        scene.getStylesheets().add("Scientific/styl.css");

        javafx.scene.text.Text tit = new javafx.scene.text.Text("Choose files");
        tit.getStyleClass().add("title");

        pane.add(tit, 0, 0, 2, 1);


        final Button file1 = new Button("Add files");
        final Button update = new Button("Check for updates");
        final Button file2 = new Button("File 2");
        final Button file3 = new Button("File 3");
        final Button save = new Button("Save graph");
        file1.setPrefSize(300, 25);
        file2.setPrefSize(100, 25);
        file3.setPrefSize(100, 25);


        final Button count = new Button("Proceed files");

        final Text file1_name = new Text("No file selected.");
        final Text file2_name = new Text("No file selected.");
        final Text file3_name = new Text("No file selected.");

        file1.getStyleClass().add("button");
        file2.getStyleClass().add("button");
        file3.getStyleClass().add("button");
        file1_name.getStyleClass().add("button");
        file2_name.getStyleClass().add("button");
        file3_name.getStyleClass().add("button");
        count.getStyleClass().add("button_count");


        pane.add(file1_name, 0, 1);
        pane.add(file2_name, 0, 2);
        pane.add(file3_name, 0, 3);
        pane.add(count, 1, 6);
        pane.add(file1, 0, 6);
        pane.add(update, 3, 6);
        pane.add(save, 2, 6);


        file1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methods.configureFileChooser(fileChooser);
                List<File> file = fileChooser.showOpenMultipleDialog(primaryStage);

                if (file != null) {
                    String f_name = file.toString();
                    System.out.println(f_name.replace("\\", "/"));

                    String names[] = f_name.split(",");


                    name1 = f_name.substring(names[0].lastIndexOf("/") + 1, names[0].length() - 4);

                    System.out.println(name1);

                    file1_name.setText(names[0].substring(1, names[0].length()));


                    name2 = f_name.substring(names[1].lastIndexOf("/") + 1, names[1].length() - 4);
                    System.out.println(name2);
                    file2_name.setText(names[1].substring(1, names[1].length()));

                    name3 = f_name.substring(names[2].lastIndexOf("/") + 1, names[2].length() - 5);
                    System.out.println(name3);
                    file3_name.setText(names[2].substring(1, names[2].length() - 1));


                }
            }
        });
        file2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methods.configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    String f_name = file.toString();
                    System.out.println(f_name.replace("\\", "/"));
                    int a = (f_name.replace("\\", "/").lastIndexOf("/"));
                    //file2_name.setText(f_name.substring(a+1,f_name.length()-4));
                    name2 = f_name.substring(a + 1, f_name.length() - 4);
                    file2_name.setText(f_name);
                }
            }
        });
        file3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methods.configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    String f_name = file.toString();
                    System.out.println(f_name.replace("\\", "/"));
                    int a = (f_name.replace("\\", "/").lastIndexOf("/"));
                    //file3_name.setText(f_name.substring(a+1,f_name.length()));
                    name3 = f_name.substring(a + 1, f_name.length() - 4);
                    file3_name.setText(f_name);
                }
            }
        });

        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //TODO add thread for that
                    Label message = new Label(methods.checkUpdate(software_version));

                    final Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    Button k = new Button("Ok");
                    dialogStage.setScene(new Scene(create().
                            children(message, k).
                            alignment(Pos.CENTER).padding(new Insets(5)).build()));

                    dialogStage.show();
                    k.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(final ActionEvent event) {

                            dialogStage.close();
                            //primaryStage.close();

                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        count.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                //todo clean up this mess!!!!!
                final Task task = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        methods.addAndCountAverageZ(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD0(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD1(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD2(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD1_PD0(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD2_PD1(file1_name.getText(), file2_name.getText(), file3_name.getText());

                        methods.saveDataFrom1File(file1_name.getText());
                        methods.saveDataFrom2File(file2_name.getText());
                        methods.saveDataFrom3File(file3_name.getText());

                        methods.normalizeDataFromFile1("PD0_PD1_1.txt");
                        methods.normalizeDataFromFile2("PD0_PD1_2.txt");
                        methods.normalizeDataFromFile3("PD0_PD1_3.txt");

                        methods.normalizeDataFromPD0_PD1("PD1-PD0_average.txt");
                        methods.createCsvFile("Z_average.txt", "PD0_average.txt", "PD1_average.txt", "PD2_average.txt", "PD1-PD0_average.txt", "PD2-PD1_average.txt", "PD0_PD1_normalised.txt", name1, "PD0_PD1_1_normalised.txt", "PD0_PD1_2_normalised.txt", "PD0_PD1_3_normalised.txt");


                        return null;
                    }
                };


                if (file1_name.getText() == "No file selected." || file1_name.getText() == "Add next file" || file2_name.getText() == "No file selected." || file2_name.getText() == "Add next file" || file3_name.getText() == "No file selected." || file3_name.getText() == "Add next file") {
                    final Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    Button k = new Button("Ok");
                    dialogStage.setScene(new Scene(create().
                            children(new Text("Please select 3 files!"), k).
                            alignment(Pos.CENTER).padding(new Insets(5)).build()));

                    dialogStage.show();
                    k.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(final ActionEvent event) {

                            dialogStage.close();
                            //primaryStage.close();

                        }
                    });

                    k.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            dialogStage.close();
                        }
                    });
                } else {
                    Thread t = new Thread(task);
                    t.setDaemon(true);
                    t.start();

                    System.out.println("wait 3 sec");
                    methods.waitTime(50000);
                    System.out.println("Done");

                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh.mm a");
                    final String generated_at = format.format(date);
                    final File outputCSV = new File("stats based on " + name1 + " " + generated_at + ".csv");

                    System.out.println(outputCSV.toString());


                    int ch = file1_name.getText().lastIndexOf("/");


                    final StackPane root = new StackPane(methods.getdataAndCreateChart(outputCSV.toString(), file1_name.getText().substring(ch + 1, file1_name.getText().length() - 4)));


                    VBox.setMargin(root, new Insets(50, 0, 0, 500));
                    final Stage stage = new Stage();
                    final Scene scene = new Scene(root, 1300, 800);


                    stage.setResizable(false);


                    stage.setTitle("Wykres");
                    stage.setScene(scene);


                    stage.show();

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            WritableImage snapShot = scene.snapshot(null);

                            try {
                                ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("graph based on " + name1 + " " + generated_at + ".png"));
                                System.out.println("Graph generated!");
                                stage.close();
                                file1_name.setText("Add next file");
                                file2_name.setText("Add next file");
                                file3_name.setText("Add next file");


                            } catch (IIOException e) {
                                System.out.println("DUPGA");
                                e.printStackTrace();
                            } catch (IOException e) {
                                System.out.println("DUPGA");
                                e.printStackTrace();

                            }
                        }
                    });


                }


            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
