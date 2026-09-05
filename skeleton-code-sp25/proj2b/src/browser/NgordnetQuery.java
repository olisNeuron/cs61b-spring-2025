package browser;

import java.util.List;

/**
 * Created by hug.
 * and liangshuo
 */
public record NgordnetQuery(List<String> words,
        int startYear,
        int endYear,
        int k) {}
