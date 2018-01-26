package org.tools.csv.validation;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OptionDetails {

    private String fullConfigName;

    private String shortConfigName;

    private String desc;

    private Boolean hasArg;

    private Boolean required;

    public Option getOption() {
        Option opt = new Option(shortConfigName, fullConfigName, hasArg, desc);
        opt.setRequired(required);

        return opt;
    }

    public boolean isPresent(CommandLine cli) {
        return cli.hasOption(this.fullConfigName);
    }

    public String getOptionValue(CommandLine cli) {
        return cli.getOptionValue(this.fullConfigName);
    }
}
