package main.java.Exam_22_August_2022.GoldDigger.core;

public interface Controller {
    String addDiscoverer(String kind, String discovererName);

    String addSpot(String spotName, String... exhibits);

    String excludeDiscoverer(String discovererName);

    String inspectSpot(String spotName);

    String getStatistics();
}
