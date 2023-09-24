
import React, {useState} from 'react';
import ReactApexChart from 'react-apexcharts';
import Detail from './Details';



const BarChart = () => {
  const [selectedGraph, setSelectedGraph] = useState('bar');

  const handleGraphChange = (event) => {
    setSelectedGraph(event.target.value);
  };
    const barChartOptions = {
      chart: {
        type: 'bar',
        background: 'transparent',
        height: 350,
        toolbar: {
          show: false,
        },
      },
      colors: ['#2962ff',  '#2e7d32', '#ff6d00', '#583cb3'],
      plotOptions: {
        bar: {
          distributed: true,
          borderRadius: 4,
          horizontal: false,
          columnWidth: '30%',
        },
      },
      dataLabels: {
        enabled: false,
      },
      fill: {
        opacity: 1,
      },
      grid: {
        borderColor: '#55596e',
        yaxis: {
          lines: {
            show: true,
          },
        },
        xaxis: {
          lines: {
            show: true,
          },
        },
      },
      legend: {
        labels: {
          colors: '#f5f7ff',
        },
        show: true,
        position: 'top',
      },
      stroke: {
        colors: ['transparent'],
        show: true,
        width: 2,
      },
      tooltip: {
        shared: true,
        intersect: false,
        theme: 'dark',
      },
      xaxis: {
        categories: ['Project1 ', 'Project2 ', 'Project3 ', 'Project4 ', 'Project5'],
        title: {
          style: {
            color: '#f5f7ff',
          },
        },
        axisBorder: {
          show: true,
          color: '#55596e',
        },
        axisTicks: {
          show: true,
          color: '#55596e',
        },
        labels: {
          style: {
            colors: '#f5f7ff',
          },
        },
      },
      yaxis: {
        title: {
          text: 'Count',
          style: {
            color: '#f5f7ff',
          },
        },
        axisBorder: {
          color: '#55596e',
          show: true,
        },
        axisTicks: {
          color: '#55596e',
          show: true,
        },
        labels: {
          style: {
            colors: '#f5f7ff',
          },
        },
      },
    };
  
    const barChartData = [
      {
        name: '',
        data: [27.3,21.7,20.3,16.7,17.2],
      },
    ];
const areaChartOptions = { 
  chart: {
    type: 'area',
    background: 'transparent',
    height: 350,
    stacked: false,
    toolbar: {
      show: false,
    },
  },
  colors: ['#d50000','#00ab57'],
  labels: ['Sun', 'Mon', 'Tue', 'Wed', 'Thur', 'Fri', 'Sat'],
  dataLabels: {
    enabled: false,
  },
  fill: {
    gradient: {
      opacityFrom: 0.4,
      opacityTo: 0.1,
      shadeIntensity: 1,
      stops: [0, 100],
      type: 'vertical',
    },
    type: 'gradient',
  },
  grid: {
    borderColor: '#55596e',
    yaxis: {
      lines: {
        show: true,
      },
    },
    xaxis: {
      lines: {
        show: true,
      },
    },
  },
  legend: {
    labels: {
      colors: '#f5f7ff',
    },
    show: true,
    position: 'top',
  },
  markers: {
    size: 6,
    strokeColors: '#1b2635',
    strokeWidth: 3,
  },
  stroke: {
    curve: 'smooth',
  },
  xaxis: {
    axisBorder: {
      color: '#55596e',
      show: true,
    },
    axisTicks: {
      color: '#55596e',
      show: true,
    },
    labels: {
      offsetY: 5,
      style: {
        colors: '#f5f7ff',
      },
    },
  },
  yaxis: [
    {
      title: {
        text: 'Project',
        style: {
          color: '#f5f7ff',
        },
      },
      labels: {
        style: {
          colors: ['#f5f7ff'],
        },
      },
    },
    {
      opposite: true,
      title: {
        text: 'Downloads',
        style: {
          color: '#f5f7ff',
        },
      },
      labels: {
        style: {
          colors: ['#f5f7ff'],
        },
      },
    },
  ],
  tooltip: {
    shared: true,
    intersect: false,
    theme: 'dark',
  }, };
  const areaChartData = [ {
    name: 'Project',
    data: [31, 40, 28, 51, 42, 109, 100],
  },
  {
    name: 'Downloads',
    data: [11, 32, 45, 32, 34, 52, 41],
  }, ];


    
    
    
  
  return (
    <>
      <Detail />
      <div className='header-title'>
        <h2>Choose Criteria:</h2>
        <select value={selectedGraph} onChange={handleGraphChange}>
          <option value="bar">Years</option>
          <option value="line">Weekly</option>
        </select>
      </div>
      <div className='header-graph'>
        <h2>{selectedGraph === 'bar' ? 'Chart' : 'Line Chart'}</h2>
        <ReactApexChart
          options={selectedGraph === 'bar' ? barChartOptions : areaChartOptions}
          series={selectedGraph === 'bar' ? barChartData : areaChartData}
          type={selectedGraph === 'bar' ? 'bar' : 'area'}
          height={300}
        />
      </div>
    </>
  );
};

export default BarChart;