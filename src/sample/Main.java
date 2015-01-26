package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javafx.geometry.Pos.CENTER;


public class Main extends Application {
    private Desktop desktop = Desktop.getDesktop();
    static Thread t = null;
    String name1,name2,name3;

    @Override
    public void start(final Stage primaryStage){

        primaryStage.setTitle("Beata's tool");
        final File saveDir = new File("Beata's tool dir");
        GridPane pane = new GridPane();
        final FileChooser fileChooser = new FileChooser();

        pane.setAlignment(CENTER);

        pane.setVgap(10);
        pane.setHgap(10);

        pane.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(pane,1000,700);
        primaryStage.setResizable(false);

        scene.getStylesheets().add("sample/styl.css");

        javafx.scene.text.Text tit = new javafx.scene.text.Text("Choose files");
        tit.getStyleClass().add("title");

        pane.add(tit,0,0,2,1);




        final Button file1 = new Button("File 1");
        final Button file2 = new Button("File 2");
        final Button file3 = new Button("File 3");
        file1.setPrefSize(100,25);
        file2.setPrefSize(100,25);
        file3.setPrefSize(100,25);


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



        pane.add(file1, 0, 1);
        pane.add(file1_name,3,1);
        pane.add(file2, 0, 2);
        pane.add(file2_name,3,2);
        pane.add(file3, 0, 3);
        pane.add(file3_name,3,3);
        pane.add(count,0,6);

        file1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methods.configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    String f_name = file.toString();
                    System.out.println(f_name.replace("\\","/"));
                    int a = (f_name.replace("\\","/").lastIndexOf("/"));
                    name1 = f_name.substring(a + 1, f_name.length()-4);
                    file1_name.setText(f_name);
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
                    System.out.println(f_name.replace("\\","/"));
                    int a = (f_name.replace("\\","/").lastIndexOf("/"));
                    //file2_name.setText(f_name.substring(a+1,f_name.length()-4));
                    name2 = f_name.substring(a+1,f_name.length()-4);
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
                    System.out.println(f_name.replace("\\","/"));
                    int a = (f_name.replace("\\","/").lastIndexOf("/"));
                    //file3_name.setText(f_name.substring(a+1,f_name.length()));
                    name3 = f_name.substring(a+1,f_name.length()-4);
                    file3_name.setText(f_name);
                }
            }
        });
        count.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {

                final Task task = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        methods.addAndCountAverageZ(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD0(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD1(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD2(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD1_PD0(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.addAndCountAveragePD2_PD1(file1_name.getText(), file2_name.getText(), file3_name.getText());
                        methods.normalizeDataFromPD0_PD1("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
                        methods.createCsvFile("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt","C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt","C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt","C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt","C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt","C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt","C:\\Users\\Public\\Beata's tool dir\\PD0_PD1_normalised.txt",name1,name2,name3);



                        return null;
                    }
                };


                if(file1_name.getText() == "No file selected." || file1_name.getText() == "Add next file" || file2_name.getText()== "No file selected." || file2_name.getText()== "Add next file" || file3_name.getText() == "No file selected." || file3_name.getText() == "Add next file"){
                    final Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    Button k = new Button("Ok");
                    dialogStage.setScene(new Scene(VBoxBuilder.create().
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
                }
                else {
                    Thread t = new Thread(task);
                    t.setDaemon(true);
                    t.start();

                    System.out.println("wait 3 sec");
                    methods.waitTime(30000);
                    System.out.println("Done");

                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh.mm a");
                    final String generated_at = format.format(date);
                    final File outputCSV = new File("stats based on " + name1 + " " + name2 + " " + name3 + " " + generated_at + ".csv");

                    System.out.println(outputCSV.toString());

                    final GridPane pane = new GridPane();
                    final Stage stage = new Stage();
                    final Scene scene = new Scene(pane);
                    final Button save = new Button("Save graph");
                    pane.add(save,1,1);

                    stage.setResizable(false);


                    stage.setTitle("Wykres");
                    stage.setScene(scene);
                    pane.getChildren().add(methods.getdataAndCreateChart(outputCSV.toString()));

                    stage.show();

                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            WritableImage snapShot = scene.snapshot(null);

                            try {
                                ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("graph based on "+ name1 + " " + name2 + " " + name3 + " " + generated_at+".png"));
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
