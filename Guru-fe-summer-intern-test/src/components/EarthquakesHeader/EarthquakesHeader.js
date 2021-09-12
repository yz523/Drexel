import React, { PureComponent } from 'react';

import 'components/EarthquakesHeader/EarthquakesHeader.css';

/**
 * Simple static component for renderering the header labels.
 *
 * PLEASE GIVE WHATEVER ELEMENTS HOLD THE LABELS A CLASSNAME OF
 * EarthquakesHeader__label
 */
export default class EarthquakesHeader extends PureComponent {
  render() {
    return (
      <thead className="EarthquakesHeader">
        <tr className="EarthquakesHeader__labels">
          <th className="EarthquakesHeader__label">Id</th>
          <th className="EarthquakesHeader__label">Time</th>
          <th className="EarthquakesHeader__label">Location</th>
          <th className="EarthquakesHeader__label">Magnitude</th>
          <th className="EarthquakesHeader__label">More</th>
        </tr>
      </thead>
    );
  }
}
