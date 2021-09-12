import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';

import EarthquakesHeader from 'components/EarthquakesHeader/EarthquakesHeader';
import EarthquakeRow from 'components/EarthquakeRow/EarthquakeRow';
import EarthquakeFilter from 'components/EarthquakeFilter/EarthquakeFilter';

import 'components/Earthquakes/Earthquakes.css';

class Earthquakes extends PureComponent {
  render() {
    const { updateFilter, earthquakes } = this.props;
    // generate rows list
    const rows = earthquakes.map(e => (
      <EarthquakeRow
        id={e.id}
        place={e.place}
        mag={e.mag}
        time={e.time}
        longitude={e.longitude}
        latitude={e.latitude}
      />
    ));

    // header + rows = table
    return (
      <div className="Earthquakes">
        <EarthquakeFilter onInput={updateFilter} />
        {
          /* render all your earthquake rows here! */
          <table className="Earthquakes__table Earthquakes__table-scroller">
            <EarthquakesHeader />
            <tbody>{rows}</tbody>
          </table>
        }
      </div>
    );
  }
}

export default Earthquakes;

Earthquakes.propTypes = {
  earthquakes: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string,
      place: PropTypes.string,
      mag: PropTypes.num,
      time: PropTypes.string,
      long: PropTypes.num,
      lat: PropTypes.num,
    })
  ),

  updateFilter: PropTypes.func.isRequired,
};

Earthquakes.defaultProps = {
  earthquakes: [],
};
