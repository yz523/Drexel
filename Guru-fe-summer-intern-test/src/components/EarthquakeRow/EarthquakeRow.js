import React, { PureComponent, Fragment } from 'react';
import PropTypes from 'prop-types';
import Moment from 'moment';

import EarthquakeDetailsButton from 'components/EarthquakeDetailsButton/EarthquakeDetailsButton';

import 'components/EarthquakeRow/EarthquakeRow.css';

/**
 * This component should render all of the columns needed
 * as well as the details button.
 *
 * PLEASE GIVE ANYTHING THAT HAS A VALUE IN IT THE CLASSNAME
 * EarthquakeRow__value
 */
export default class EarthquakeRow extends PureComponent {
  constructor() {
    super();

    this.state = { expanded: false };
    this.toggleDetails = this.toggleDetails.bind(this);
  }

  toggleDetails() {
    this.setState(state => ({ expanded: !state.expanded }));
  }

  render() {
    /** Don't forget to format the time here! */
    const { id, time, place, mag, longitude, latitude } = this.props;
    const newTime = Moment(time).format('MMMM DD, YYYY @ HH:mm');
    // The details column render a button that says details
    let details = <EarthquakeDetailsButton onClick={this.toggleDetails} />;

    // Clicking on it show the longitude and latitude for the earthquake.
    if (this.state.expanded) {
      details = (
        <Fragment className="EarthquakeRow__details">
          <td className="EarthquakeRow__detail">longitude: {longitude}</td>
          <td className="EarthquakeRow__detail">latitude: {latitude}</td>
        </Fragment>
      );
    }

    return (
      /* This should return the details, all the values, and the details button */
      <tr className="EarthquakeRow">
        <td className="EarthquakeRow__value">{id}</td>
        <td className="EarthquakeRow__value">{newTime}</td>
        <td className="EarthquakeRow__value">{place}</td>
        <td className="EarthquakeRow__value">{mag}</td>
        <td className="EarthquakeRow__value">{details}</td>
      </tr>
    );
  }
}

EarthquakeRow.propTypes = {
  id: PropTypes.string,
  time: PropTypes.string,
  place: PropTypes.string,
  mag: PropTypes.number,
  longitude: PropTypes.number,
  latitude: PropTypes.number,
};

EarthquakeRow.defaultProps = {
  id: '',
  time: '',
  place: '',
  mag: 0,
  longitude: 0,
  latitude: 0,
};
