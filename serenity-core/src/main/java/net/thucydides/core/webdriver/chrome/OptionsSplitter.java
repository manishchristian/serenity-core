package net.thucydides.core.webdriver.chrome;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class OptionsSplitter {
    public List<String> split(String chromeSwitches) {
        CharMatcher trimmable = CharMatcher.anyOf(" ,;");
        Splitter.on("--").trimResults().split(chromeSwitches);
        List<String> options = Lists.newArrayList(Splitter.on("--").omitEmptyStrings().trimResults(trimmable).split(chromeSwitches));

        return options.stream()
                .map(option -> "--" + option)
                .collect(Collectors.toList());
    }
}
