package ngrams;

import org.antlr.v4.runtime.tree.Tree;

import java.util.*;

/**
 * An object for mapping a year number (e.g. 1996) to numerical data. Provides
 * utility methods useful for data analysis.
 *
 * @author Josh Hug
 */
public class TimeSeries extends TreeMap<Integer, Double> {

    /** If it helps speed up your code, you can assume year arguments to your NGramMap
     * are between 1400 and 2100. We've stored these values as the constants
     * MIN_YEAR and MAX_YEAR here. */
    public static final int MIN_YEAR = 1400;
    public static final int MAX_YEAR = 2100;

    /**
     * Constructs a new empty TimeSeries.
     */
    public TimeSeries() {
        super();
    }

    public TimeSeries(int year, double times) {
        super();
        TimeSeries ts = new TimeSeries(year, times);
    }
    /**
     * Creates a copy of TS, but only between STARTYEAR and ENDYEAR,
     * inclusive of both end points.
     */
    public TimeSeries(TimeSeries ts, int startYear, int endYear) {
        super();
        ts = new TimeSeries();
        ts.put(startYear, 0.0);
        ts.put(endYear, 0.0);
    }

    /**
     *  Returns all years for this time series in ascending order.
     */
    public List<Integer> years() {
        return new ArrayList<>(this.keySet());
    }

    /**
     *  Returns all data for this time series. Must correspond to the
     *  order of years().
     */
    public List<Double> data() {
        ArrayList<Double> data = new ArrayList<>();
        for (int year : this.keySet()) {
            data.add(this.get(year));
        }
        return data;
    }

    /**
     * Returns the year-wise sum of this TimeSeries with the given TS. In other words, for
     * each year, sum the data from this TimeSeries with the data from TS. Should return a
     * new TimeSeries (does not modify this TimeSeries).
     *
     * If both TimeSeries don't contain any years, return an empty TimeSeries.
     * If one TimeSeries contains a year that the other one doesn't, the returned TimeSeries
     * should store the value from the TimeSeries that contains that year.
     */
    public TimeSeries plus(TimeSeries ts) {
        if (ts.isEmpty() && this.isEmpty()) {
            return new TimeSeries();
        }
        if (ts.isEmpty()) {return this;}
        if (this.isEmpty()) {return ts;}

        for (int year : ts.keySet()) {
            if (this.containsKey(year)) {
                this.put(year, ts.get(year)+this.get(year));
            } else {
                this.put(year, ts.get(year));
            }
        }

        return this;
    }

    /**
     * Returns the quotient of the value for each year this TimeSeries divided by the
     * value for the same year in TS. Should return a new TimeSeries (does not modify this
     * TimeSeries).
     *
     * If TS is missing a year that exists in this TimeSeries, throw an
     * IllegalArgumentException.
     * If TS has a year that is not in this TimeSeries, ignore it.
     */
    public TimeSeries dividedBy(TimeSeries ts) {
        for (int year : this.keySet()) {
            if (!ts.containsKey(year)) {
                throw new IllegalArgumentException();
            }
        }

        TimeSeries quotient = new TimeSeries();
        for (int year : ts.keySet()) {
            quotient.put(year, this.get(year) / ts.get(year));
        }
        return quotient;
    }
}
