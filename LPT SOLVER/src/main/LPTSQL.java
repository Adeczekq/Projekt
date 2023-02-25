package main;

import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

public class LPTSQL extends polacz {
    public void LPT(int numMachines) throws FileNotFoundException {
        try {
            Statement stmt = con.createStatement();
            // Czytanie danych z bazy
            String query = "SELECT nazwa, czas FROM LPT2";
            ResultSet rs = stmt.executeQuery(query);
            List<String> taskNames = new ArrayList<>();
            List<Integer> times = new ArrayList<>();
            while (rs.next()) {
                taskNames.add(rs.getString("nazwa"));
                times.add(rs.getInt("czas"));
            }
            List<Integer> tasks = new ArrayList<>();
            for (int i = 0; i < times.size(); i++) {
                tasks.add(i);
            }

            // Sortowanie zadań po czasie malejąco
            Collections.sort(tasks, (a, b) -> times.get(b) - times.get(a));

            // Tablica do przechowywania łącznego czasu dla danej maszyny
            int[] machineTimes = new int[numMachines];

            // przypisanie zadania do maszyny z najmniejszym łącznym czasem
            List<Integer>[] assignedTasks = new List[numMachines];
            for (int i = 0; i < numMachines; i++) {
                assignedTasks[i] = new ArrayList<>();
            }
            for (int task : tasks) {
                int minIndex = getMinIndex(machineTimes);
                machineTimes[minIndex] += times.get(task);
                assignedTasks[minIndex].add(task);
            }
            // Wyświetlenie odpowiedzi algorytmu LPT
            String solution = "";
            PrintWriter zapis = new PrintWriter("rozwiązanie.txt");
            TaskSeriesCollection dataset = new TaskSeriesCollection();

            for (int i = 0; i < numMachines; i++) {
                int Start = 0;
                int end = 0;
                int c=1;
                String nazwa = "Maszyna" +" "+ (i + 1);
                TaskSeries series = new TaskSeries(nazwa);
                solution += "Maszyna " + (i + 1) + ": ";
                for (int task : assignedTasks[i]) {
                        if (c == 1) {
                            end = Start + times.get(task);
                        } else {
                            Start = end;
                            end += times.get(task);
                        }
                        c++;
                        series.add(new Task(taskNames.get(task), new Date(Start), new Date(end)));
                    solution += taskNames.get(task) + " " + times.get(task) + ", ";
                }
                    dataset.add(series);
                    solution = StringUtils.chop(solution);
                    solution = StringUtils.chop(solution);
                    solution += "\n";

                }
                JOptionPane.showMessageDialog(null, solution);
                zapis.println(solution);
                zapis.close();
                JFreeChart chart = ChartFactory.createGanttChart(
                        "Wykres Gantta dla algorytmu LPT",
                        "Zadania",
                        "Czas",
                        dataset,
                        true,
                        true,
                        false);

                CategoryPlot plot = (CategoryPlot) chart.getPlot();
                plot.setOrientation(PlotOrientation.HORIZONTAL);

                chart.getTitle().setFont(new Font("Arial", Font.BOLD, 14));
                chart.getLegend().setItemFont(new Font("Arial", Font.PLAIN, 12));
                plot.getDomainAxis().setLabelFont(new Font("Arial", Font.BOLD, 12));
                plot.getRangeAxis().setLabelFont(new Font("Arial", Font.BOLD, 12));

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(800, 600));
                JFrame frame = new JFrame("Wykres Gantta dla algorytmu LPT");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(chartPanel);
                frame.pack();
                frame.setVisible(true);

            }
        catch(SQLException e1){
                e1.printStackTrace();
            }
        }

        public static int getMinIndex ( int[] arr){
            int minIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            return minIndex;
        }
}