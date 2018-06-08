// We have created three sample data sets here
// and in real application this data will be returned in similar format
// from server
// *************************************************************************
// IMPORTANT NOTE : All the data formatting should be done on server itself
// as doing it on client will have performance issue. Best will be to
// format data in desired form while getting out of database itself
// List of columns used by Charts

// *************************************************************************
// 	Daily Chart :
//  createdDate --> string in MM/DD/YYYY format (or whatever format you want) 
//  earnings --> number, Total earnings for given date
//  redirects --> number, Total clicks for given date
// *************************************************************************

// *************************************************************************
// 	Monthly Chart :
//  monthName --> string in MM-YY format (get MonthName and year at database level itself)
//  having year with month name will help in recongnizing bars if data set spans over 2 years 
//  earnings --> number, Total earnings for given month-year
//  redirects --> number, Total clicks for given month-year
// *************************************************************************

// *************************************************************************
// 	Yearly Chart :
//  year --> string in YYYY format (get year at database level itself) 
//  earnings --> number, Total earnings for given year
//  redirects --> number, Total clicks for given year
// *************************************************************************

/**
 * Sample data for last seven days, in real project replace this with api
 * call, server should return total earnings and clicks for given date
 * as shown in sample data
 * @export
 * @returns
 */
export function getDailyEarningsAndClicks() {
	return Promise.resolve([
		{
			creationDate: '05/25/2018',
			earnings: 100,
			redirects: 60,
		},
		{
			creationDate: '05/26/2018',
			earnings: 10,
			redirects: 40,
		},
		{
			creationDate: '05/27/2018',
			earnings: 60,
			redirects: 100,
		},
		{
			creationDate: '05/28/2018',
			earnings: 43,
			redirects: 35,
		},
		{
			creationDate: '05/29/2018',
			earnings: 40,
			redirects: 23,
		},
		{
			creationDate: '05/30/2018',
			earnings: 120,
			redirects: 59,
		},
		{
			creationDate: '05/31/2018',
			earnings: 10,
			redirects: 40,
		},
	]);
}

/**
 * Sample data by months, in real project replace this with api
 * call, server should return total earnings and clicks by given month
 * as shwon in sample data
 * @export
 * @returns
 */
export function getMonthlyEarningsAndClicks() {
	return Promise.resolve([
		{
			monthName: 'Jan-18',
			earnings: 100,
			redirects: 60,
		},
		{
			monthName: 'Feb-18',
			earnings: 10,
			redirects: 40,
		},
		{
			monthName: 'Mar-18',
			earnings: 60,
			redirects: 100,
		},
		{
			monthName: 'Apr-18',
			earnings: 43,
			redirects: 35,
		},
		{
			monthName: 'May-18',
			earnings: 40,
			redirects: 23,
		},
		{
			monthName: 'Jun-18',
			earnings: 120,
			redirects: 59,
		},
		{
			monthName: 'Jul-18',
			earnings: 10,
			redirects: 40,
		},
		{
			monthName: 'Aug-18',
			earnings: 67,
			redirects: 89,
		},
		{
			monthName: 'Sep-18',
			earnings: 35,
			redirects: 12,
		},
		{
			monthName: 'Oct-18',
			earnings: 110,
			redirects: 88,
		},
		{
			monthName: 'Nov-18',
			earnings: 120,
			redirects: 65,
		},
		{
			monthName: 'Dec-18',
			earnings: 85,
			redirects: 120,
		},
	]);
}


/**
 * Sample data by year, in real project replace this with api
 * call, server should return total earnings and clicks by given year
 * as shwon in sample data
 * @export
 * @returns
 */
export function getYearlyEarningsAndClicks() {
	return Promise.resolve([
		{
			year: '2014',
			earnings: 120,
			redirects: 70,
		},
		{
			year: '2015',
			earnings: 100,
			redirects: 60,
		},
		{
			year: '2016',
			earnings: 80,
			redirects: 40,
		},
		{
			year: '2017',
			earnings: 60,
			redirects: 100,
		},
		{
			year: '2018',
			earnings: 43,
			redirects: 35,
		},
	]);
}