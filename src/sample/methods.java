package sample;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wapeł on 2015-01-13.
 */
public class methods {
    public static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View files");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv")
        );
    }

    public static void addAndCountAverageZ(String file1_string, String file2_string, String file3_string) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);

        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));
            BufferedWriter out;

            int counter = 0;
            int iteration = 0;
            double data = 0;
            double average = 0;


            File saveDir = new File("C:\\Users\\Public\\Beata's tool dir\\");
            File f1 = new File("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt");
            File f2 = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt");
            File f3 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt");
            File f4 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt");
            File f5 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
            File f6 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt");


            if (!saveDir.exists()) {
                System.out.println("creating dir" + saveDir.toString());
                boolean result = false;
                try {
                    saveDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    System.out.println("Dir created");
                    saveDirPath = saveDir.getAbsolutePath().toString();

                }
            } else {
                saveDirPath = saveDir.getAbsolutePath().toString();
            }


            String line = "";
            String line2 = "";
            String line3 = "";

            //average for Z


            FileOutputStream fos = new FileOutputStream(f1);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);
                String[] data2 = line2.split(cvsSplitBy);
                String[] data3 = line3.split(cvsSplitBy);

                data = Double.parseDouble(data1[1]) + Double.parseDouble(data2[1]) + Double.parseDouble(data3[1]);
                average = data / 3;


                bw.write(String.valueOf(average));
                bw.newLine();


            }
            br1.close();
            br2.close();
            br3.close();
            bw.close();
            System.out.println("Z average generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addAndCountAveragePD0(String file1_string, String file2_string, String file3_string) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);

        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));
            BufferedWriter out;

            int counter = 0;
            int iteration = 0;
            double data = 0;
            double average = 0;


            File saveDir = new File("C:\\Users\\Public\\Beata's tool dir\\");
            File f1 = new File("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt");
            File f2 = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt");
            File f3 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt");
            File f4 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt");
            File f5 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
            File f6 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt");


            if (!saveDir.exists()) {
                System.out.println("creating dir" + saveDir.toString());
                boolean result = false;
                try {
                    saveDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    System.out.println("Dir created");
                    saveDirPath = saveDir.getAbsolutePath().toString();

                }
            } else {
                saveDirPath = saveDir.getAbsolutePath().toString();
            }


            String line = "";
            String line2 = "";
            String line3 = "";

            //average for Z


            FileOutputStream fos = new FileOutputStream(f2);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);
                String[] data2 = line2.split(cvsSplitBy);
                String[] data3 = line3.split(cvsSplitBy);

                data = Double.parseDouble(data1[2]) + Double.parseDouble(data2[2]) + Double.parseDouble(data3[2]);
                average = data / 3;


                bw.write(String.valueOf(average));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            br2.close();
            br3.close();
            bw.close();
            System.out.println("PD0 average generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addAndCountAveragePD1(String file1_string, String file2_string, String file3_string) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);

        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));
            BufferedWriter out;

            int counter = 0;
            int iteration = 0;
            double data = 0;
            double average = 0;


            File saveDir = new File("C:\\Users\\Public\\Beata's tool dir\\");
            File f1 = new File("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt");
            File f2 = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt");
            File f3 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt");
            File f4 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt");
            File f5 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
            File f6 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt");


            if (!saveDir.exists()) {
                System.out.println("creating dir" + saveDir.toString());
                boolean result = false;
                try {
                    saveDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    System.out.println("Dir created");
                    saveDirPath = saveDir.getAbsolutePath().toString();

                }
            } else {
                saveDirPath = saveDir.getAbsolutePath().toString();
            }


            String line = "";
            String line2 = "";
            String line3 = "";

            //average for Z


            FileOutputStream fos = new FileOutputStream(f3);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);
                String[] data2 = line2.split(cvsSplitBy);
                String[] data3 = line3.split(cvsSplitBy);

                data = Double.parseDouble(data1[3]) + Double.parseDouble(data2[3]) + Double.parseDouble(data3[3]);
                average = data / 3;


                bw.write(String.valueOf(average));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            br2.close();
            br3.close();
            bw.close();
            System.out.println("PD1 average generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addAndCountAveragePD2(String file1_string, String file2_string, String file3_string) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);

        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));
            BufferedWriter out;

            int counter = 0;
            int iteration = 0;
            double data = 0;
            double average = 0;


            File saveDir = new File("C:\\Users\\Public\\Beata's tool dir\\");
            File f1 = new File("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt");
            File f2 = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt");
            File f3 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt");
            File f4 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt");
            File f5 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
            File f6 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt");


            if (!saveDir.exists()) {
                System.out.println("creating dir" + saveDir.toString());
                boolean result = false;
                try {
                    saveDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    System.out.println("Dir created");
                    saveDirPath = saveDir.getAbsolutePath().toString();

                }
            } else {
                saveDirPath = saveDir.getAbsolutePath().toString();
            }


            String line = "";
            String line2 = "";
            String line3 = "";

            //average for Z


            FileOutputStream fos = new FileOutputStream(f4);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);
                String[] data2 = line2.split(cvsSplitBy);
                String[] data3 = line3.split(cvsSplitBy);

                data = Double.parseDouble(data1[4]) + Double.parseDouble(data2[4]) + Double.parseDouble(data3[4]);
                average = data / 3;


                bw.write(String.valueOf(average));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            br2.close();
            br3.close();
            bw.close();
            System.out.println("PD2 average generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addAndCountAveragePD1_PD0(String file1_string, String file2_string, String file3_string) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);

        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));

            int counter = 0;
            int iteration = 0;
            double data = 0;
            double average = 0;


            File saveDir = new File("C:\\Users\\Public\\Beata's tool dir\\");
            File f1 = new File("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt");
            File f2 = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt");
            File f3 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt");
            File f4 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt");
            File f5 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
            File f6 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt");


            if (!saveDir.exists()) {
                System.out.println("creating dir" + saveDir.toString());
                boolean result = false;
                try {
                    saveDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    System.out.println("Dir created");
                    saveDirPath = saveDir.getAbsolutePath().toString();

                }
            } else {
                saveDirPath = saveDir.getAbsolutePath().toString();
            }


            String line = "";
            String line2 = "";
            String line3 = "";

            //average for Z


            FileOutputStream fos = new FileOutputStream(f5);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);
                String[] data2 = line2.split(cvsSplitBy);
                String[] data3 = line3.split(cvsSplitBy);

                data = Double.parseDouble(data1[5]) + Double.parseDouble(data2[5]) + Double.parseDouble(data3[5]);
                average = data / 3;


                bw.write(String.valueOf(average));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            br2.close();
            br3.close();
            bw.close();
            System.out.println("PD1-PD0 average generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addAndCountAveragePD2_PD1(String file1_string, String file2_string, String file3_string) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);

        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));


            int counter = 0;
            int iteration = 0;
            double data = 0;
            double average = 0;


            File saveDir = new File("C:\\Users\\Public\\Beata's tool dir\\");
            File f1 = new File("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt");
            File f2 = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt");
            File f3 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt");
            File f4 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt");
            File f5 = new File("C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt");
            File f6 = new File("C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt");


            if (!saveDir.exists()) {
                System.out.println("creating dir" + saveDir.toString());
                boolean result = false;
                try {
                    saveDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    System.out.println("Dir created");
                    saveDirPath = saveDir.getAbsolutePath().toString();

                }
            } else {
                saveDirPath = saveDir.getAbsolutePath().toString();
            }


            String line = "";
            String line2 = "";
            String line3 = "";

            //average for Z


            FileOutputStream fos = new FileOutputStream(f6);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);
                String[] data2 = line2.split(cvsSplitBy);
                String[] data3 = line3.split(cvsSplitBy);

                data = Double.parseDouble(data1[6]) + Double.parseDouble(data2[6]) + Double.parseDouble(data3[6]);
                average = data / 3;


                bw.write(String.valueOf(average));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            br2.close();
            br3.close();
            bw.close();
            System.out.println("PD2-PD1 average generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void normalizeDataFromPD0_PD1(String file1_string) {
        File f1 = new File(file1_string);
        File output = new File("C:\\Users\\Public\\Beata's tool dir\\PD0_PD1_normalised.txt");


        int counter = 0;
        double firstValInFile = 0;
        double data;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            FileOutputStream fos = new FileOutputStream(output);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));


            String line;
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    firstValInFile = Double.parseDouble(line);
                    counter++;
                }
                data = Double.parseDouble(line) / firstValInFile;


                bw.write(String.valueOf(data));
                bw.newLine();

            }
            br.close();
            bw.close();
            System.out.println("normalized PD0-PD1 generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCsvFile(String file1_string, String file2_string, String file3_string, String file4_string, String file5_string, String file6_string, String file7_string, String lel1, String lel2, String lel3) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);
        File file4 = new File(file4_string);
        File file5 = new File(file5_string);
        File file6 = new File(file6_string);
        File file7 = new File(file7_string);

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy hh.mm a");
        String generated_at = df.format(date);


        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedReader br3 = new BufferedReader(new FileReader(file3));
            BufferedReader br4 = new BufferedReader(new FileReader(file4));
            BufferedReader br5 = new BufferedReader(new FileReader(file5));
            BufferedReader br6 = new BufferedReader(new FileReader(file6));
            BufferedReader br7 = new BufferedReader(new FileReader(file7));



            File outputCSV = new File("stats based on " + lel1 + " " + lel2 + " " + lel3 + " " + generated_at + ".csv");


            String line = "";
            String line2 = "";
            String line3 = "";
            String line4 = "";
            String line5 = "";
            String line6 = "";
            String line7 = "";



            FileWriter writer = new FileWriter(outputCSV);
            writer.append("No" + "," + "z" + "," + "PD0" + "," + "PD1" + "," + "PD2" + "," + "PD1/PD0" + "," + "PD2/PD1" + "," + "Normalised PD0/PD1");
            writer.append("\n");

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null && (line4 = br4.readLine()) != null && (line5 = br5.readLine()) != null && (line6 = br6.readLine()) != null && (line7 = br7.readLine()) != null) {


                writer.append(line + "," + line + "," + line2 + "," + line3 + "," + line4 + "," + line5 + "," + line6 + "," + line7);
                writer.append("\n");

            }
            br1.close();
            br2.close();
            br3.close();
            br4.close();
            br5.close();
            br6.close();
            br7.close();
            writer.flush();
            writer.close();
            cleanUpOldFiles("C:\\Users\\Public\\Beata's tool dir\\Z_average.txt", "C:\\Users\\Public\\Beata's tool dir\\PD0_average.txt", "C:\\Users\\Public\\Beata's tool dir\\PD1_average.txt", "C:\\Users\\Public\\Beata's tool dir\\PD2_average.txt", "C:\\Users\\Public\\Beata's tool dir\\PD1-PD0_average.txt", "C:\\Users\\Public\\Beata's tool dir\\PD2-PD1_average.txt", "C:\\Users\\Public\\Beata's tool dir\\PD0_PD1_normalised.txt");


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void cleanUpOldFiles(String file1_string, String file2_string, String file3_string, String file4_string, String file5_string, String file6_string, String file7_string) {
        File f1 = new File(file1_string);
        File f2 = new File(file2_string);
        File f3 = new File(file3_string);
        File f4 = new File(file4_string);
        File f5 = new File(file5_string);
        File f6 = new File(file6_string);
        File f7 = new File(file7_string);


        try {
            f1.delete();
            f2.delete();
            f3.delete();
            f4.delete();
            f5.delete();
            f6.delete();
            f7.delete();


            System.out.println("Cleaned up!");
        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }

    }

    public static AreaChart<Number, Number> getdataAndCreateChart(String file_string) {
        File file1 = new File(file_string);


        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();


        int line_count = 0;
        double[] full_data1 = new double[100];
        double[] full_data2 = new double[100];

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy hh.mm a");
        String generated_at = df.format(date);


        AreaChart<Number, Number> ac = new AreaChart<Number, Number>(xAxis, yAxis);
        int iteration = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));


            String split_by = ",";
            String line1 = "";


            while ((line1 = br.readLine()) != null) {
                if (iteration < 1) {
                    iteration++;
                    continue;
                }
                String data[] = line1.split(split_by);


                // setup chart
                ac.setTitle("Chart " + generated_at);
                xAxis.setLabel("X Axis");
                yAxis.setLabel("Y Axis");
                // add starting data

                double x = Double.parseDouble(data[0]);
                double y = Double.parseDouble(data[7]);
                if (line_count <= 99) {
                    full_data1[line_count] = x;
                    full_data2[line_count] = y;
                }
                line_count++;


            }
            br.close();
            for (int s = 0; s < 1; s++) {
                XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
                series.setName("Data Series " + s);
                int x = 0;
                while (x <= 99) {
                    series.getData().add(new XYChart.Data<Number, Number>(full_data1[x], full_data2[x]));
                    x++;
                }

                ac.getData().add(series);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ac;
    }

    public static void waitTime(long millisecond) {
        long max = millisecond;
        for (long i = 0; i < max; i++) {
            for (long j = 0; j < max; j++) {

            }
        }
    }


}
