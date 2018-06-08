// Here we will create all the settings needed by the chart
// Option 1 - Showing bar chart for daily earnings
// CreationDate will be on x-axis 
// Earnings and Redirects will be on y-axis in 2 bar charts

// Measure key, this will be the property name which we want to use on y-axis
// in our case it will be earnings or clicks

// MeasureName will be used to show label on y-axis

// Dimension key, this will be the property name which we want to use on x-axis
// in our case it will be date, month or year

// Dimension name will be used to show label on x-axis

// Chart size is also part of this config, so that we can have different
// sizes of the chart as per selected chart type

const EARNINGS_BY_DATE = {
	measureKey: 'earnings',
	measureName: 'Earnings',
	dimensionKey: 'creationDate',
	dimensionName: 'Creation Date',
	chartTitle: 'Daily Earnings (Last 7 days)',
	chartWidth: 800,
	chartHeight: 300,
};

const CLICKS_BY_DATE = {
	measureKey: 'redirects',
	measureName: 'Clicks',
	dimensionKey: 'creationDate',
	dimensionName: 'Creation Date',
	chartTitle: 'Daily Clicks (Last 7 days)',
	chartWidth: 800,
	chartHeight: 300,
};

const EARNINGS_BY_MONTH = {
	measureKey: 'earnings',
	measureName: 'Earnings',
	dimensionKey: 'monthName',
	dimensionName: 'Month',
	chartTitle: 'Monthly Earnings',
	chartWidth: 800,
	chartHeight: 300,
};

const CLICKS_BY_MONTH = {
	measureKey: 'redirects',
	measureName: 'Clicks',
	dimensionKey: 'monthName',
	dimensionName: 'Month',
	chartTitle: 'Monthly Clicks',
	chartWidth: 800,
	chartHeight: 300,
};

const EARNINGS_BY_YEAR = {
	measureKey: 'earnings',
	measureName: 'Earnings',
	dimensionKey: 'year',
	dimensionName: 'Year',
	chartTitle: 'Yearly Earnings',
	chartWidth: 800,
	chartHeight: 300,
};

const CLICKS_BY_YEAR = {
	measureKey: 'redirects',
	measureName: 'Clicks',
	dimensionKey: 'year',
	dimensionName: 'Year',
	chartTitle: 'Yearly Clicks',
	chartWidth: 800,
	chartHeight: 300,
};

export default function getChartConfigs() {
	return {
		daily: {
			earningsChartConfig: EARNINGS_BY_DATE,
			clicksChartConfig: CLICKS_BY_DATE,
		},
		monthly: {
			earningsChartConfig: EARNINGS_BY_MONTH,
			clicksChartConfig: CLICKS_BY_MONTH,
		},
		yearly: {
			earningsChartConfig: EARNINGS_BY_YEAR,
			clicksChartConfig: CLICKS_BY_YEAR,
		},
	};
}