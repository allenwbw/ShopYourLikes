import React from 'react';
import { Select, Card } from 'antd';
import BarChart from './visuals/BarChart';
import getChartConfigs from './chartConstants';
import {
  getDailyEarningsAndClicks,
  getMonthlyEarningsAndClicks,
  getYearlyEarningsAndClicks,
} from './sampleChartData';

import './statsDashboard.css';

const CHART_OPTIONS = {
  Daily: 'Daily',
  Monthly: 'Monthly',
  Yearly: 'Yearly',
};

// antd exposes option for dropdown under same name space
// just assign to a a variable and we will use it later in dropdown
const SelectOption = Select.Option;

/**
 * This is container component for our visuals
 * and same visuals can be added anywhere else as well
 * we just need to make sure that relevant props and data is passed in
 * to the visual components
 * @export
 * @class App
 * @extends {React.Component}
 */
export default class App extends React.Component {
  constructor(props) {
    super(props);
    // We will keep chart option and chart data in state
    // so that whenever we change chart type we can use
    // new chart config and get new data from server
    this.state = {
      selectedChartOption: CHART_OPTIONS.Daily,
      chartData: [],
    };

    // bind handler so that this refers to component
    this.handleChartTypeChange = this.handleChartTypeChange.bind(this);
  }

  componentDidMount() {
    // Load initial data for default chart option
    // in our case default chart option is daily
    this.getChartData(this.state.selectedChartOption);
  }

  /**
   * This function will request data from server as per selected
   * chart option, this either make a api call or dipatch an action
   * to get data from store, in case redux and mob is being used make sure
   * to handle data load accordingly
   * @memberof App
   * @param chartOption Selected chart option in dropdown
   */
  getChartData(chartOption) {
    let dataLoadPromise = undefined;
    switch (chartOption) {

      // Daily option is selected, load daily data
      case CHART_OPTIONS.Daily:
        dataLoadPromise = getDailyEarningsAndClicks();
        break;

      // Monthly option is selected, load monthly data
      case CHART_OPTIONS.Monthly:
        dataLoadPromise = getMonthlyEarningsAndClicks();
        break;

      // Yearly option is selected, load yearly data
      case CHART_OPTIONS.Yearly:
        dataLoadPromise = getYearlyEarningsAndClicks();
        break;
    }
    // we will handle promise here and set the data returned by server
    // in component state, so that chart can re-render
    if (dataLoadPromise) {
      dataLoadPromise
        .then((chartData) => {
          this.setState({ chartData });
        })
        .catch((err) => {
          // use your error handling for handling server side errors
          console.error(err);
        });
    }
  }

  /**
   * This function will return the chart config as per selected chart type option
   * This config will tell us which field we will be using on x and y axis
   * that means what will be our measure and dimension for the chart
   * we have pre-configured our chart options in chartConstants and we will pick the 
   * one as applicable here for selected chart option
   * @memberof App
   * @return Chart config options for earnings and clicks bar chart
   */
  getSelectedChartConfig() {
    let selectedChartConfig;
    const allChartConfigs = getChartConfigs();
    switch (this.state.selectedChartOption) {
      // Daily option is selected, use daily chart config
      case CHART_OPTIONS.Daily:
        selectedChartConfig = allChartConfigs.daily;
        break;
      // Monthly option is selected, use monthly chart config
      case CHART_OPTIONS.Monthly:
        selectedChartConfig = allChartConfigs.monthly;
        break;
      // Yearly option is selected, use yearly chart config
      case CHART_OPTIONS.Yearly:
        selectedChartConfig = allChartConfigs.yearly;
        break;
    }
    return selectedChartConfig;
  }
  /**
   * handler for chart type select
   * this will set selected chart type in state and request data for
   * selected chart option
   * @param {*} selectedChartOption Selected chart option in dropdown
   * @memberof App
   */
  handleChartTypeChange(selectedChartOption) {
    this.setState({ selectedChartOption, chartData: [] });
    this.getChartData(selectedChartOption);
  }

  render() {
    //Below is basic setup for the bar chart, same can be used in any other component
    // to integrate
    // container id will be id of div element where we want append the bar chart
    const earningChartContainerId = 'earningBarChartContainer';
    const clicksChartContainerId = 'clicksBarChartContainer';

    // get chart config as per selected chart type
    const selectedChartConfig = this.getSelectedChartConfig();
    if (selectedChartConfig) {
      // get config for both bar chart and pass on to BarChart component
      // with data and other props
      const earningsChartConfig = selectedChartConfig.earningsChartConfig;
      const clicksChartConfig = selectedChartConfig.clicksChartConfig;
      return (
        <Card title="Earnings and Clicks dashboard">
          <label htmlFor="chartTypeSelect">{'Select Chart Type'}</label>
          <Select
            id="chartTypeSelect"
            defaultValue={CHART_OPTIONS.Daily}
            className="chart-type-selector"
            onChange={this.handleChartTypeChange}
            value={this.state.selectedChartOption}
          >
            <SelectOption value={CHART_OPTIONS.Daily}>{CHART_OPTIONS.Daily}</SelectOption>
            <SelectOption value={CHART_OPTIONS.Monthly}>{CHART_OPTIONS.Monthly}</SelectOption>
            <SelectOption value={CHART_OPTIONS.Yearly}>{CHART_OPTIONS.Yearly}</SelectOption>
          </Select>
          <BarChart
            containerId={earningChartContainerId}
            chartData={this.state.chartData}
            chartConfig={earningsChartConfig}
          />
          <BarChart
            containerId={clicksChartContainerId}
            chartData={this.state.chartData}
            chartConfig={clicksChartConfig}
          />
        </Card>
      );
    } else {
      // This will never happen, added just for completeness sake
      return <div>{'Invalid chart option selected'}</div>
    }
  }
}