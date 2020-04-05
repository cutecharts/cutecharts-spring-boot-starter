package com.koy.cutecharts.properties;

import com.koy.cutecharts.options.BaseOptions;
import com.koy.cutecharts.options.GlobalOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2020/04/04
 */
@ConfigurationProperties(prefix = "cutecharts")
public class CuteChartsProperties {

    private boolean autoGenChart;
    private List<String> chartTypes;
    private GlobalOptions globalOptions;
    private BaseOptions options;


    public List<String> getChartTypes() {
        return chartTypes;
    }

    public void setChartTypes(List<String> chartTypes) {
        this.chartTypes = chartTypes;
    }

    public GlobalOptions getGlobalOptions() {
        return globalOptions;
    }

    public void setGlobalOptions(GlobalOptions globalOptions) {
        this.globalOptions = globalOptions;
    }

    public BaseOptions getOptions() {
        return options;
    }

    public void setOptions(BaseOptions options) {
        this.options = options;
    }

    public boolean isAutoGenChart() {
        return autoGenChart;
    }

    public void setAutoGenChart(boolean autoGenChart) {
        this.autoGenChart = autoGenChart;
    }
}
