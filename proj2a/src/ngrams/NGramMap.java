package ngrams;

import edu.princeton.cs.algs4.In;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static ngrams.TimeSeries.MAX_YEAR;
import static ngrams.TimeSeries.MIN_YEAR;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 *
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
public class NGramMap {

    Map<String, TimeSeries> wordFileMap;
    Map<Integer, Long> countsFileMap;
    /**
     * Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME.
     */
    public NGramMap(String wordsFilename, String countsFilename) {
        // initialize constructor variable
        wordFileMap = new HashMap<String, TimeSeries>();
        countsFileMap = new HashMap<Integer, Long>();
        In inWordFile = new In(wordsFilename);
        In inCountFile = new In(countsFilename);

        // transfer data of csv files into hash mapping
        while (!inWordFile.isEmpty()) {
            String nextLine = inWordFile.readLine();
            String[] splitLine = nextLine.split("\t");
            String word = splitLine[0];
            int year = Integer.parseInt(splitLine[1]);
            double value = Double.parseDouble(splitLine[2]);
            if (!wordFileMap.containsKey(word)) {
                wordFileMap.put(word, new TimeSeries());
            }
            wordFileMap.get(word).put(year, value);
        }

        while (!inCountFile.isEmpty()) {
            String nextLine = inCountFile.readLine();
            String[] splitLine = nextLine.split(",");
            countsFileMap.put(Integer.parseInt(splitLine[0]), Long.parseLong(splitLine[1]));
        }
    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other
     * words, changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy". If the word is not in the data files,
     * returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        if (wordFileMap.containsKey(word)) {
            TimeSeries originalData = wordFileMap.get(word);
            TimeSeries data = new TimeSeries();
            for (int i = startYear; i < endYear+1; i+=1) {
                if (originalData.containsKey(i)) {
                    data.put(i, originalData.get(i));
                }
            }
            return data;
        }
        return new TimeSeries();
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy, not a link to this
     * NGramMap's TimeSeries. In other words, changes made to the object returned by this function
     * should not also affect the NGramMap. This is also known as a "defensive copy". If the word
     * is not in the data files, returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word) {
        if (wordFileMap.containsKey(word)) {
            TimeSeries originalData = wordFileMap.get(word);
            return new TimeSeries(originalData, MIN_YEAR, MAX_YEAR);
        }
        return new TimeSeries();
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        TimeSeries result = new TimeSeries();
        for (Map.Entry<Integer, Long> entry : countsFileMap.entrySet()) {
            int year = entry.getKey();
            long counts = entry.getValue();
            result.put(year, (double) counts);
        }
        return result;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        TimeSeries frequency = new TimeSeries();
        if (wordFileMap.containsKey(word)) {
            TimeSeries wordData = wordFileMap.get(word);
            for (int year : wordData.keySet()) {
                if (year >= startYear && year <= endYear) {
                    frequency.put(year, wordData.get(year) / countsFileMap.get(year));
                }
            }
            return frequency;
        }
        return new TimeSeries();
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to all
     * words recorded in that year. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word) {
        TimeSeries frequency = new TimeSeries();
        if (wordFileMap.containsKey(word)) {
            TimeSeries wordData = wordFileMap.get(word);
            for (int year : wordData.keySet()) {
                frequency.put(year, wordData.get(year)/countsFileMap.get(year));
            }
            return frequency;
        }
        return new TimeSeries();
    }

    /**
     * Provides the summed relative frequency per year of all words in WORDS between STARTYEAR and
     * ENDYEAR, inclusive of both ends. If a word does not exist in this time frame, ignore it
     * rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words,
                                          int startYear, int endYear) {
        TimeSeries result = new TimeSeries();
        for (String word : words) {
            TimeSeries wordHistory = weightHistory(word, startYear, endYear);
            for (int year : wordHistory.keySet()) {
                double freq = wordHistory.get(year);
                if (result.containsKey(year)) {
                    result.put(year, result.get(year) + freq);
                } else {
                    result.put(year, freq);
                }
            }
        }
        return result;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS. If a word does not
     * exist in this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        TimeSeries result = new TimeSeries();
        for (String word : words) {
            TimeSeries wordHistory = weightHistory(word);
            for (int year : wordHistory.keySet()) {
                double freq = wordHistory.get(year);
                if (result.containsKey(year)) {
                    result.put(year, result.get(year) + freq);
                } else {
                    result.put(year, freq);
                }
            }
        }
        return result;
    }
}
