
package Scientific;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.FileChooser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
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


            File saveDir = new File("");
            File f1 = new File("Z_average.txt");
            File f2 = new File("PD0_average.txt");
            File f3 = new File("PD1_average.txt");
            File f4 = new File("PD2_average.txt");
            File f5 = new File("PD1-PD0_average.txt");
            File f6 = new File("PD2-PD1_average.txt");


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


            File saveDir = new File("");
            File f1 = new File("Z_average.txt");
            File f2 = new File("PD0_average.txt");
            File f3 = new File("PD1_average.txt");
            File f4 = new File("PD2_average.txt");
            File f5 = new File("PD1-PD0_average.txt");
            File f6 = new File("PD2-PD1_average.txt");


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


            File saveDir = new File("");
            File f1 = new File("Z_average.txt");
            File f2 = new File("PD0_average.txt");
            File f3 = new File("PD1_average.txt");
            File f4 = new File("PD2_average.txt");
            File f5 = new File("PD1-PD0_average.txt");
            File f6 = new File("PD2-PD1_average.txt");


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


            File saveDir = new File("");
            File f1 = new File("Z_average.txt");
            File f2 = new File("PD0_average.txt");
            File f3 = new File("PD1_average.txt");
            File f4 = new File("PD2_average.txt");
            File f5 = new File("PD1-PD0_average.txt");
            File f6 = new File("PD2-PD1_average.txt");


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


            File saveDir = new File("");
            File f1 = new File("Z_average.txt");
            File f2 = new File("PD0_average.txt");
            File f3 = new File("PD1_average.txt");
            File f4 = new File("PD2_average.txt");
            File f5 = new File("PD1-PD0_average.txt");
            File f6 = new File("PD2-PD1_average.txt");


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


            File saveDir = new File("");
            File f1 = new File("Z_average.txt");
            File f2 = new File("PD0_average.txt");
            File f3 = new File("PD1_average.txt");
            File f4 = new File("PD2_average.txt");
            File f5 = new File("PD1-PD0_average.txt");
            File f6 = new File("PD2-PD1_average.txt");


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

    public static void saveDataFrom1File(String file1_string) {
        File file1 = new File(file1_string);


        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));

            int iteration = 0;
            double data = 0;


            File saveDir = new File("");
            File f3 = new File("PD0_PD1_1.txt");


            String line = "";


            FileOutputStream fos = new FileOutputStream(f3);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);


                data = Double.parseDouble(data1[5]);


                bw.write(String.valueOf(data));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            bw.close();
            System.out.println("PD0/PD1 for file 1 saved");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDataFrom2File(String file1_string) {
        File file1 = new File(file1_string);


        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));

            int iteration = 0;
            double data = 0;


            File saveDir = new File("");
            File f3 = new File("PD0_PD1_2.txt");


            String line = "";


            FileOutputStream fos = new FileOutputStream(f3);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);


                data = Double.parseDouble(data1[5]);


                bw.write(String.valueOf(data));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            bw.close();
            System.out.println("PD0/PD1 for file 2 saved");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDataFrom3File(String file1_string) {
        File file1 = new File(file1_string);


        String saveDirPath;
        String cvsSplitBy = ",";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));

            int iteration = 0;
            double data = 0;


            File saveDir = new File("");
            File f3 = new File("PD0_PD1_3.txt");


            String line = "";


            FileOutputStream fos = new FileOutputStream(f3);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            while ((line = br1.readLine()) != null) {
                if (iteration <= 2) {
                    iteration++;
                    continue;
                }
                String[] data1 = line.split(cvsSplitBy);


                data = Double.parseDouble(data1[5]);


                bw.write(String.valueOf(data));
                bw.newLine();
                //System.out.println("Saved average "+average);


            }
            br1.close();
            bw.close();
            System.out.println("PD0/PD1 for file 3 saved");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void normalizeDataFromPD0_PD1(String file1_string) {
        File f1 = new File(file1_string);


        File output1 = new File("PD0_PD1_normalised.txt");


        int counter = 0;
        double firstValInFile = 0;
        double data;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            FileOutputStream fos = new FileOutputStream(output1);
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

    public static void normalizeDataFromFile1(String file1_string) {
        File f1 = new File(file1_string);
        File output = new File("PD0_PD1_1_normalised.txt");

        int counter = 0;
        double firstValueInFile = 0;
        double data;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            FileOutputStream fos = new FileOutputStream(output);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    firstValueInFile = Double.parseDouble(line);
                    counter++;
                }
                data = Double.parseDouble(line) / firstValueInFile;

                bw.write(String.valueOf(data));
                bw.newLine();


            }
            br.close();
            bw.close();
            System.out.println("normalized PD0-PD1 for file 1 generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void normalizeDataFromFile2(String file1_string) {
        File f1 = new File(file1_string);
        File output = new File("PD0_PD1_2_normalised.txt");

        int counter = 0;
        double firstValueInFile = 0;
        double data;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            FileOutputStream fos = new FileOutputStream(output);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    firstValueInFile = Double.parseDouble(line);
                    counter++;
                }
                data = Double.parseDouble(line) / firstValueInFile;

                bw.write(String.valueOf(data));
                bw.newLine();


            }
            br.close();
            bw.close();
            System.out.println("normalized PD0-PD1 for file 2 generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void normalizeDataFromFile3(String file1_string) {
        File f1 = new File(file1_string);
        File output = new File("PD0_PD1_3_normalised.txt");

        int counter = 0;
        double firstValueInFile = 0;
        double data;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            FileOutputStream fos = new FileOutputStream(output);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    firstValueInFile = Double.parseDouble(line);
                    counter++;
                }
                data = Double.parseDouble(line) / firstValueInFile;

                bw.write(String.valueOf(data));
                bw.newLine();


            }
            br.close();
            bw.close();
            System.out.println("normalized PD0-PD1 for file 3 generated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createCsvFile(String file1_string, String file2_string, String file3_string, String file4_string, String file5_string, String file6_string, String file7_string, String lel1, String normalised1, String normalised2, String normalised3) {
        File file1 = new File(file1_string);
        File file2 = new File(file2_string);
        File file3 = new File(file3_string);
        File file4 = new File(file4_string);
        File file5 = new File(file5_string);
        File file6 = new File(file6_string);
        File file7 = new File(file7_string);

        File file8 = new File(normalised1);
        File file9 = new File(normalised2);
        File file10 = new File(normalised3);

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

            BufferedReader br8 = new BufferedReader(new FileReader(file8));
            BufferedReader br9 = new BufferedReader(new FileReader(file9));
            BufferedReader br10 = new BufferedReader(new FileReader(file10));


            File outputCSV = new File("stats based on " + lel1 + " " + generated_at + ".csv");


            String line = "";
            String line2 = "";
            String line3 = "";
            String line4 = "";
            String line5 = "";
            String line6 = "";
            String line7 = "";

            String line8 = "";
            String line9 = "";
            String line10 = "";


            FileWriter writer = new FileWriter(outputCSV);
            writer.append("No" + "," + "z" + "," + "PD0" + "," + "PD1" + "," + "PD2" + "," + "PD1/PD0" + "," + "PD2/PD1" + "," + "Normalised PD0/PD1" + "," + "Normalised PD0/PD1 File 1" + "," + "Normalised PD0/PD1 File 2" + "," + "Normalised PD0/PD1 File 3");
            writer.append("\n");

            while ((line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null && (line = br1.readLine()) != null && (line4 = br4.readLine()) != null && (line5 = br5.readLine()) != null && (line6 = br6.readLine()) != null && (line7 = br7.readLine()) != null && (line8 = br8.readLine()) != null && (line9 = br9.readLine()) != null && (line10 = br10.readLine()) != null) {


                writer.append(line + "," + line + "," + line2 + "," + line3 + "," + line4 + "," + line5 + "," + line6 + "," + line7 + "," + line8 + "," + line9 + "," + line10);
                writer.append("\n");

            }
            br1.close();
            br2.close();
            br3.close();
            br4.close();
            br5.close();
            br6.close();
            br7.close();
            br8.close();
            br9.close();
            br10.close();
            writer.flush();
            writer.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void cleanUpOldFiles(String file1_string, String file2_string, String file3_string, String file4_string, String file5_string, String file6_string, String file7_string, String file8_string, String file9_string, String file10_string, String file11_string, String file12_string, String file13_string) {
        File f1 = new File(file1_string);
        File f2 = new File(file2_string);
        File f3 = new File(file3_string);
        File f4 = new File(file4_string);
        File f5 = new File(file5_string);
        File f6 = new File(file6_string);
        File f7 = new File(file7_string);

        File f8 = new File(file8_string);
        File f9 = new File(file9_string);
        File f10 = new File(file10_string);
        File f11 = new File(file11_string);
        File f12 = new File(file12_string);
        File f13 = new File(file13_string);


        try {
            f1.delete();
            f2.delete();
            f3.delete();
            f4.delete();
            f5.delete();
            f6.delete();
            f7.delete();
            f8.delete();
            f9.delete();
            f10.delete();
            f11.delete();
            f12.delete();
            f13.delete();


            System.out.println("Cleaned up!");
        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }

    }

    public static LineChart<Number, Number> getdataAndCreateChart(String file_string, String filename) {
        File file1 = new File(file_string);


        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis(0.85, 1.6, 0.05);


        int line_count = 0;
        double[] full_data1 = new double[100];
        double[] full_data2 = new double[100];


        double[] full_data_file1_2 = new double[100];


        double[] full_data_file2_2 = new double[100];


        double[] full_data_file3_2 = new double[100];

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy hh.mm a");
        String generated_at = df.format(date);


        LineChart<Number, Number> ac = new LineChart<Number, Number>(xAxis, yAxis);
        ac.setCreateSymbols(false);
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
                ac.setTitle(filename);
                xAxis.setLabel("z[mm]");
                yAxis.setLabel("Normalized Transmission");
                // add starting data

                double x = Double.parseDouble(data[0]);
                double y = Double.parseDouble(data[7]);
                double y1 = Double.parseDouble(data[8]);
                double y2 = Double.parseDouble(data[9]);
                double y3 = Double.parseDouble(data[10]);

                if (line_count <= 99) {
                    full_data1[line_count] = x;
                    full_data2[line_count] = y;

                    full_data_file1_2[line_count] = y1;
                    full_data_file2_2[line_count] = y2;
                    full_data_file3_2[line_count] = y3;
                }
                line_count++;


            }
            br.close();

            XYChart.Series series = new XYChart.Series();
            int x = 0;
            series.setName("Main normalised");
            while (x <= 99) {

                series.getData().add(new XYChart.Data(full_data1[x], full_data2[x]));
                x++;

            }

            XYChart.Series series1 = new XYChart.Series();
            int x1 = 0;
            series1.setName("1 File normalised");
            while (x1 <= 99) {
                series1.getData().add(new XYChart.Data(full_data1[x1], full_data_file1_2[x1]));
                x1++;
            }

            XYChart.Series series2 = new XYChart.Series();
            int x2 = 0;
            series2.setName("2 File normalised");
            while (x2 <= 99) {
                series2.getData().add(new XYChart.Data(full_data1[x2], full_data_file2_2[x2]));
                x2++;
            }

            XYChart.Series series3 = new XYChart.Series();
            int x3 = 0;
            series3.setName("3 File normalised");
            while (x3 <= 99) {
                series1.getData().add(new XYChart.Data(full_data1[x3], full_data_file3_2[x3]));
                x3++;
            }


            ac.getData().addAll(series, series1, series2, series3);


            cleanUpOldFiles("Z_average.txt", "PD0_average.txt", "PD1_average.txt", "PD2_average.txt", "PD1-PD0_average.txt", "PD2-PD1_average.txt", "PD0_PD1_normalised.txt", "PD0_PD1_1_normalised.txt", "PD0_PD1_2_normalised.txt", "PD0_PD1_3_normalised.txt", "PD0_PD1_1.txt", "PD0_PD1_2.txt", "PD0_PD1_3.txt");


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

    public static String checkUpdate(double local_version) throws IOException, URISyntaxException {

        String message="";

        String url = "http://szydlowsky.com/apps/tool/version.html";
        Document doc = Jsoup.connect(url).get();
        String data = doc.text();
        System.out.println(data);
        if(Double.parseDouble(doc.text())==local_version){
            message = "You are using the newest version.";
        }
        else if(local_version<Double.parseDouble(doc.text())) {
            message = "Update found! Version "+doc.text()+" avaliable.\n Download window will open now.";
            Desktop.getDesktop().browse(new URI("http://szydlowsky.com/apps/tool/"));
        }
        else{
            message = "Something went wring. Try again later";
        }
        return message.toString();
    }
}
