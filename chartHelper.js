// This is the only file where we will use d3 to create visuals
// but actual component will be exposed as react component only
import * as d3 from 'd3';

/**
 * This function will draw the bar chart  with given config options and 
 * data.
 *
 * @export
 * @param Title of the chart
 * @param {*} containerId Id of the div where chart will be rendered. This will be an empty div 
 * as d3 will append svg to it to render the chart
 * @param {*} chartWidth width of the chart, should be equal or less than to width of container div
 * @param {*} chartHeight height of the chart, should be equal or less than to height of container div
 * @param {*} chartData Array of data to be used in chart
 * @param {*} measureKey Measure key to be used on y-axis values
 * @param {*} measureName Measure Name to be used on y-axis label
 * @param {*} dimensionKey Dimension key to be used on x-axis values
 * @param {*} dimensionName Dimension Name to be used on x-axis label
 */
export function drawBarChart(
	chartTitle,
	containerId,
	chartWidth,
	chartHeight,
	chartData,
	measureKey,
	measureName,
	dimesnionKey,
	dimensionName) {
	// We will validate all the parameters as they are required to
	// create the visuals
	// Chart container should be part of DOM, so that d3 selection
	// can work
	if (!containerId || d3.select(`#${containerId}`).empty()) {
		throw new Error('Chart conatiner id is null or element does not exist.');
	}
	// Valid chart container passed, we will clean out the chart container to make sure
	// nothing is present
	const chartContainer = d3.select(`#${containerId}`);
	chartContainer
		.style('opacity', 1)
		.transition()
		.ease(d3.easeLinear)
		.duration(500)
		.style('opacity', 0);

	chartContainer.html('');

	// Chart data should be valid array and non-zero length
	if (chartData && Array.isArray(chartData) && chartData.length > 0) {
		// Height and Width should be valid numbers greater than 0
		// Also there value should be meaningful. Too small values
		// will result in errors while creating visuals
		if (isNaN(+chartHeight) || isNaN(+chartWidth)) {
			throw new Error('Chart height and width should valid positive numebrs.');
		}

		// We will need valid measure key to plot y-axis values
		// and this key should belong to objects present in chartData array
		if (!(measureKey && Object.keys(chartData[0]).indexOf(measureKey) !== -1)) {
			console.warn(measureKey);
			throw new Error('Measure key is not valid. This property should exist on objects of chart data array.');
		}

		// We will need valid dimension key to plot x-axis values
		// and this key should belong to objects present in chartData array
		if (!(dimesnionKey && Object.keys(chartData[0]).indexOf(dimesnionKey) !== -1)) {
			console.warn(dimesnionKey);
			throw new Error('Dimension key is not valid. This property should exist on objects of chart data array.');
		}

		// Measure Name and Dimension Name are optional, if we do not have them
		// we can use Measure Key and Dimension Key for axis-labels

		// All the inputs are valid, will setup chart margins now
		// We add margins to make sure we have some space left
		// for labels on axis etc.
		const margin = { top: 10, right: 10, bottom: 35, left: 50 };
		const width = +chartWidth - margin.left - margin.right;
		const height = +chartHeight - margin.top - margin.bottom;

		// We will use ordinal scale on x-axis as we have discrete values
		const xAxisScale = d3.scaleBand().rangeRound([0, width]).padding(0.1);
		// We will use linear scale on y-axis as we have range of values
		const yAxisScale = d3.scaleLinear().rangeRound([height, 0]);

		// We will use  a ordinal scale for color, although we have 
		// a bar chart and all the bars will have same color, but in case
		// different colors are needed for each bar, we just need to add more
		// colors to the scale or use a chromatic color scheme
		// refer : https://github.com/d3/d3-scale-chromatic
		const colorScale = d3.scaleOrdinal().range(['#2e76b5']);

		// Add tooltip
		const chartTooltip = chartContainer
			.append('div')
			.attr("id", `${containerId}_CHART_TOOLTIP`)
			.attr("class", `chart-tooltip`)
			.style('opacity', 0);
		// Append main svg and group elements, they will root level elements of
		// our visual
		const svg = chartContainer
			.append('svg')
			.attr("id", `${containerId}_CHART_SVG`)
			.attr('width', chartWidth)
			.attr('height', chartHeight);

		// Append group element, and translate it using margins
		// so that we draw in this group, but will have some space on sides
		// for axis and labels
		const mainChartGroup = svg.append("g")
			.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

		// We will use chart data, measure key and dimesnion key to get
		// domain for our x and y axis

		// For x-axis, we will get all unique dimension names from chartData
		const dimesnionNames =
			d3.map(chartData, d => d[dimesnionKey]).keys();

		// For y-axis we will need range of values to plot max and min on y-scale
		const maxMeasureValue = d3.max(chartData, function (d) { return d[measureKey]; })
		// Set domain on scales
		xAxisScale.domain(dimesnionNames);
		yAxisScale.domain([0, maxMeasureValue]);
		// Color scale will also use these values for domain
		colorScale.domain(dimesnionNames);

		// Draw x-axis
		mainChartGroup.append("g")
			.attr("class", "axis axis--x")
			.attr("transform", "translate(0," + height + ")")
			.call(d3.axisBottom(xAxisScale))
			.style('opacity', 0)
			.transition()
			.ease(d3.easeLinear)
			.duration(1000)
			.style('opacity', 1);
		// Add x-axis label
		mainChartGroup.append("text")
			.attr("class", "label x-axis--label")
			.attr("x", width / 2)
			.attr("y", height + 25)
			.attr("dy", "0.71em")
			.attr("text-anchor", "middle")
			.text(dimensionName || dimesnionKey);

		// Draw y-axis 
		mainChartGroup.append("g")
			.attr("class", "axis axis--y")
			.call(d3.axisLeft(yAxisScale).ticks(10, "s"))
			.style('opacity', 0)
			.transition()
			.ease(d3.easeLinear)
			.duration(1000)
			.style('opacity', 1);

		// Add y-axis label
		mainChartGroup.append("text")
			.attr("transform", "rotate(-90)")
			.attr("class", "label y-axis--label")
			// .attr("x", width / 2)
			.attr("y", -45)
			.attr("dy", "0.71em")
			.attr("text-anchor", "end")
			.text(measureName || measureKey);

		// Draw actual bars as per given data
		mainChartGroup.selectAll(".bar")
			.data(chartData)
			.enter()
			.append("rect")
			.attr("class", "bar")
			.style('fill', d => colorScale(d[dimesnionKey]))
			.attr("x", d => xAxisScale(d[dimesnionKey]))
			.attr("y", height)
			.attr("width", xAxisScale.bandwidth())
			.attr("height", 0)
			.on("mouseover", function (d) {
				// create tooltip data using current bar's data
				const tooltipData = [];
				tooltipData.push(`<div class="chart-tooltip--title"><h4>${chartTitle}</h4></div>`);
				tooltipData.push(`<h5">${dimensionName || dimesnionKey} : ${d[dimesnionKey]}</h5><br/>`);
				tooltipData.push(`<h5">${measureName || measureKey} : ${d[measureKey]}</h5>`);

				// Show tool tip using data of current bar
				// set x and y of tooltip as per mouse cursor
				console.log(d3.event.pageX, d3.event.pageY);
				chartTooltip.html(tooltipData.join(' '))
					.style("left", (d3.event.pageX + 10) + "px")
					.style("top", (d3.event.pageY - 28) + "px");
				console.log(chartTooltip.node());
				// Make tooltip visible
				chartTooltip.transition()
					.duration(200)
					.style("opacity", 1);
			})
			.on("mouseout", function (d) {
				// hide tooltip
				chartTooltip.transition()
					.duration(200)
					.style("opacity", 0);
			})
			.transition()
			.ease(d3.easeLinear)
			.duration(500)
			.attr("y", d => yAxisScale(d[measureKey]))
			.attr("height", d => height - yAxisScale(d[measureKey]))

		d3.select(`#${containerId}`)
			.style('opacity', 0)
			.transition()
			.ease(d3.easeLinear)
			.duration(500)
			.style('opacity', 1);
	}
}