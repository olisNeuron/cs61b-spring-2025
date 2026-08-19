package main;
import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;
import ngrams.NGramMap;
import ngrams.TimeSeries;
import org.knowm.xchart.XYChart;
import plotting.Plotter;

import java.util.ArrayList;
import java.util.List;

public class HistoryTextHandler extends NgordnetQueryHandler {
    NGramMap ngm;
    public HistoryTextHandler(NGramMap map) {
        ngm = map;
    }

    @Override
    public String handle(NgordnetQuery q) {
        String response = "";
        for (String word : q.words()) {
            TimeSeries ts = ngm.weightHistory(word, q.startYear(), q.endYear());
            response += word + ": " + ts.toString() + "\n";
        }
        return response;
    }

    }


