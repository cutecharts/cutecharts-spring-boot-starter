package com.koy.cutecharts.autoconfiguration;

import com.koy.cutecharts.core.ChartBuilder;
import com.koy.cutecharts.options.GlobalOptions;
import com.koy.cutecharts.properties.CuteChartsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2020/04/04
 */
@Configuration
@EnableConfigurationProperties(CuteChartsProperties.class)
public class CuteChartsConfiguration {

    @Bean
    @Autowired
    @Scope("prototype")
    public ChartBuilder.newChart newChart(CuteChartsProperties cuteChartsProperties) {
        ChartBuilder.newChart newChart = new ChartBuilder.newChart();
        GlobalOptions globalOptions = Optional.ofNullable(cuteChartsProperties.getGlobalOptions()).orElseGet(GlobalOptions::new);
        newChart.setGlobalOptions(globalOptions);
        return newChart;
    }
}
