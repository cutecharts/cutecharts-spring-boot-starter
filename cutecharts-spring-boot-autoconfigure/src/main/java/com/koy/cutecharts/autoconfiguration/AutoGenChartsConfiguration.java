package com.koy.cutecharts.autoconfiguration;

import com.koy.cutecharts.chart.Chart;
import com.koy.cutecharts.core.ChartBuilder;
import com.koy.cutecharts.core.ChartFactory;
import com.koy.cutecharts.enums.ChartType;
import com.koy.cutecharts.options.BaseOptions;
import com.koy.cutecharts.options.GlobalOptions;
import com.koy.cutecharts.properties.CuteChartsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2020/04/04
 */
@Configuration
@ConditionalOnProperty(prefix = "cutecharts", name = "auto-gen-chart", havingValue = "true")
public class AutoGenChartsConfiguration {

    @Bean
    @Autowired
    public ChartFactory chartFactory(CuteChartsProperties cuteChartsProperties) {
        List<String> chartTypes = cuteChartsProperties.getChartTypes();
        GlobalOptions globalOptions = Optional.ofNullable(cuteChartsProperties.getGlobalOptions()).orElseGet(GlobalOptions::new);
        List<Chart> charts = new ArrayList<>(chartTypes.size());
        BaseOptions options = cuteChartsProperties.getOptions();
        for (String ct : chartTypes) {
            ChartType chartType = Enum.valueOf(ChartType.class, ct.toUpperCase());
            ChartBuilder.newChart newChart = new ChartBuilder.newChart(chartType, globalOptions);
            options.setChartType(chartType);
            newChart.setOptions(options);
            charts.add(newChart.build());
        }
        return new ChartFactory(charts);
    }
}
