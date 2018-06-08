import React from 'react';
import PropTypes from 'prop-types';
import './barChart.css';
import * as chartHelper from './chartHelper';

/**
 * This is a simple wrapper component, it will receive chart props and
 * pass on the same to d3 based helpers to create actual chart. And will only
 * render a div which will contain our chart
 * @export
 * @class BarChart
 * @extends {React.PureComponent}
 */
export default class BarChart extends React.PureComponent {
	constructor(props) {
		super(props);
	}

	/**
	 * This component is not going to render anything, it will simply
	 * pass on the props to chart helper function for d3
	 * @memberof BarChart
	 */
	render() {
		// Get all the prop values for chart
		const {
			containerId,
			chartData,
			chartConfig,
		} = this.props;

		// get chart measure and dimension from chart config
		const {
			chartTitle,
			measureKey,
			measureName,
			dimensionKey,
			dimensionName,
			chartWidth,
			chartHeight,
		} = chartConfig;

		// we will call chart helper function in a setTimeout to make sure
		// React is done with DOM rendering and d3 does not interfere with it
		// and also the container element will be there to append svg
		setTimeout(() => {
			chartHelper.drawBarChart(
				chartTitle,
				containerId,
				chartWidth,
				chartHeight,
				chartData,
				measureKey,
				measureName,
				dimensionKey,
				dimensionName,
			);
		}, 10);
		// we will assign same dimension style to chart container div, so that
		// we have valid area to draw chart
		const chartContainerStyle = {
			width: chartWidth,
			height: chartHeight
		};

		// In this component we will create a div with given container ID, and let d3 use this
		// div for chart creation, as this is ID, so it is assumed that there will only be one
		// div with same ID		
		return (
			<div className="card">
				<div className="chart-title">
					{chartTitle}
				</div>
				<div
					className="chart-container"
					id={containerId}
					style={chartContainerStyle}
				>
				</div>
			</div>
		);
	}
}

/** 
* Prop types for our bar chart component, these are mainly 
* chart configuration
*/
BarChart.propTypes = {
	/** Id of the div where chart will be rendered. This will be an empty div  */
	containerId: PropTypes.string.isRequired,
	/** Array of data to be used in chart */
	chartData: PropTypes.array.isRequired,
	chartConfig: PropTypes.shape({
		/** Title of the chart to display */
		chartTitle: PropTypes.string.isRequired,
		/** Measure key to be used on y-axis values */
		measureKey: PropTypes.string.isRequired,
		/** Measure Name to be used on y-axis label */
		measureName: PropTypes.string,
		/** Dimension key to be used on x-axis values */
		dimensionKey: PropTypes.string.isRequired,
		/** Dimension Name to be used on x-axis label */
		dimensionName: PropTypes.string,
		/** width of the chart, should be equal or less than to width of container div */
		chartWidth: PropTypes.number.isRequired,
		/** height of the chart, should be equal or less than to height of container div */
		chartHeight: PropTypes.number.isRequired,
	}).isRequired,
}