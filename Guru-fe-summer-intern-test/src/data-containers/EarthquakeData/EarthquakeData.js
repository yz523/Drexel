import React, { Component } from 'react';

import organizeEarthquakes from 'utils/organizeEarthquakes';

/**
 * Data Container for the app.  A higher order function that returns a container.
 *
 * https://medium.com/@dan_abramov/smart-and-dumb-components-7ca2f9a7c7d0
 *
 * It's main job is to fetch the earthquakes data from endpoint
 * and pipe that into the earthquakes component.  As well as to handle the data
 * filtering, sorting and slicing.
 */

export default function EarthquakeData(WrappedComponent) {
  return class extends Component {
    constructor() {
      super();

      this.state = {
        filter: '',
        earthquakes: [],
        organizedEarthquakes: [],
      };

      this.updateFilter = this.updateFilter.bind(this);
    }

    async componentDidMount() {
      /**
       * Write the logic to fetch the earthquakes here
       * It should sort filter and slice the data as soon as it loads.
       * this should be achieved with the organizeEarthquakes function you write
       */
      try {
        const url = 'http://interviewtest.getguru.com/seismic/data.json';
        const response = await fetch(url);
        const json = await response.json();
        // input json data to list "earthquakes"
        this.setEarthquakes(json);
        // update the filter
        this.updateFilter(this.state.filter);
      } catch (e) {
        console.log(e);
      }
    }

    setEarthquakes(json) {
      this.setState({
        earthquakes: json,
      });
    }

    updateFilter(filter) {
      const { earthquakes } = this.state;

      this.setState({
        organizedEarthquakes: organizeEarthquakes(filter, earthquakes),
      });
    }

    render() {
      const { organizedEarthquakes } = this.state;
      return (
        <WrappedComponent
          {...this.props}
          earthquakes={organizedEarthquakes}
          updateFilter={this.updateFilter}
        />
      );
    }
  };
}
