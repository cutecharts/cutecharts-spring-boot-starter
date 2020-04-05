<p align="center">
    <img src="https://user-images.githubusercontent.com/19553554/66697551-27384b00-ed09-11e9-9fe8-210918fdeb77.png" alt="cutecharts.java logo" width=600/>
</p>

<p align=center>
    <i>:snowboarder: A spring boot starter for cutecharts.</i>
</p>

##  📣 Description

- There is a starter for [cutecharts.java](https://github.com/cutecharts/cutecharts.java) 🎨.
- You can import it easily to ur SpringBoot project :bike:.

## 📝 Useage
>:apple: Notice:  Firstly, you need install all the dependencies in ur local or central repo.

> Support:     
> - JDK1.8+  
> - cutechart.java v1.0.1+  

### Import Dependency
> pom.xml
```xml
<dependency>
    <groupId>com.koy.cutecharts</groupId>
    <artifactId>cutecharts-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Basic Usage
Normally, when u import the starter, there has a non-specific chart type `Chart.newChart` bean created.  
You can use it to create the charts whatever you want.

```java
@Autowired
ChartBuilder.newChart newChart;
...

DataSet dataSet3 = new DataSet("amount", new Integer[]{1, 2, 3, 4, 5});
// use the autowired newChart to build chart
ChartBuilder.newChart newChart = this.newChart.setChart(ChartType.PIE);
PieOptions pieOptions = new PieOptions();
pieOptions.setInnerRadius(0);
Chart pie = newChart
      .setLabels(new String[]{"apple", "banana", "orange", "lemon", "watermelon", "strawberry"})
      .setData(dataSet3)
      .build();
RenderExecutor.render(pie, new File("pie.html"));
```

### Advanced Usage

Specially, If you only have some basic configuration and chart types, u can specific them at the `application.yml` directly.
When u set `auto-gen-chart = true`, there will have all the specific charts instances stored in the `ChartFactory`.

> application.yml
```yaml
cutecharts:
  auto-gen-chart: true
  chart-types:
         - bar
         - line
  global-options:
    title: Demo-Title
  options:
    backgroundColor: yellow
```


```java
@Autowired
ChartFactory chartFactory;
...
// Line demo
DataSet dataSet1 = new DataSet("Beer", new Integer[]{1, 2, 3, 4, 2, 5, 4});
DataSet dataSet2 = new DataSet("Juice", new Integer[]{1, 4, 7, 4, 1, 3, 2});

Chart line = chartFactory.getChart(ChartType.LINE);
line.setxLabel("x-axis");
line.setyLabel("y-axis");
Data data = new Data();
data.setLabels(new Integer[]{1, 2, 3, 4, 5, 6, 7});
data.appendDataSet(dataSet1);
data.appendDataSet(dataSet2);
line.setData(data);
RenderExecutor.render(line, new File("line.html"));

// Bar demo
DataSet dataSet = new DataSet(new Integer[]{2, 3, 4, 2, 5, 4});

Chart bar = chartFactory.getChart(ChartType.BAR);
bar.setxLabel("x-axis");
bar.setyLabel("y-axis");
Data data1 = new Data();
data1.setLabels(new String[]{"apple", "banana", "orange", "lemon", "watermelon", "strawberry"});
data1.appendDataSet(dataSet);
bar.setData(data1);
RenderExecutor.render(bar, new File("bar.html"));
```  

## 📃 License

MIT [©Koy](https://github.com/Koooooo-7)
