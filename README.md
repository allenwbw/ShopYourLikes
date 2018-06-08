### Visuals for react app using d3

### Assuming you already have webpack setup for your app, you just need to copy the components from this code base
#### Install d3js using npm/yarn --> npm i --save d3
#### You are already using antd, so that is not a new dependency
####
#### Integration steps
1. Copy the components in your source code
2. BarChart component is the important one and its a simple wrapper component given correct props value it will create a bar chart
3. chartConstants.js has config options for chart, and we will use config from this as per chart type selection.
4. sampleChartData.js has sample data sets for all type of charts, in your case server should return the same dataset.
5. StatsDashboard.js has an example usage of the component and chart selector dropdown
6. Use StatsDashboard.js in your app and replace with your data api calls to get chart data
7. package.json has all the dependencies listed

### This is working application once all the npm packages are installed, you should be able to view the visuals with sample data
1. Copy the code from the attached zip
2. Go to root directory of codebase, where package.json is and run `npm i`
3. Once all the packages are installed, run app using `npm start`

### Thanks ajkaushik~
