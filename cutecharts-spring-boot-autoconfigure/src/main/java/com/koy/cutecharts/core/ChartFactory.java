package com.koy.cutecharts.core;

import com.koy.cutecharts.chart.Chart;
import com.koy.cutecharts.enums.ChartType;

import java.util.List;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2020/04/04
 */
public class ChartFactory {

    private List<Chart> chartBuilders;

    public ChartFactory(List<Chart> chartBuilders) {
        this.chartBuilders = chartBuilders;
    }

    /*potential concurrent issues*/
    public Chart getChart(ChartType chartType) {
        for (Chart cb : chartBuilders) {
            if (cb.getType().equals(chartType.getSymbol())) {
                return cb;
            }
        }
        return null;
    }
}
