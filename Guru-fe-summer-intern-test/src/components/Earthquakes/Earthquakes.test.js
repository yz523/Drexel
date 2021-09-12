import React from 'react';
import { shallow } from 'enzyme';

import Earthquakes from 'components/Earthquakes/Earthquakes';
import EarthquakeFilter from 'components/EarthquakeFilter/EarthquakeFilter';
import EarthquakeRow from 'components/EarthquakeRow/EarthquakeRow';

import mockEarthquakeData from '../../../__mocks__/mockEarthquakeData';

describe('component - Earthquakes', () => {
  it('renders one <EarthquakeFilter>', () => {
    const comp = shallow(
      <Earthquakes earthquakes={mockEarthquakeData} updateFilter={() => {}} />
    );
    const input = comp.find(EarthquakeFilter);

    // All of these values should statically
    // stay the same.  Date is going to be harder because they
    // will probably transform it.
    expect(input).toHaveLength(1);
  });

  it('renders an <EarthquakeRow> for each object in earthquakes prop', () => {
    const comp1 = shallow(
      <Earthquakes earthquakes={mockEarthquakeData} updateFilter={() => {}} />
    );
    const comp2 = shallow(
      <Earthquakes
        earthquakes={mockEarthquakeData.slice(0, 25)}
        updateFilter={() => {}}
      />
    );

    const rows1 = comp1.find(EarthquakeRow);
    const rows2 = comp2.find(EarthquakeRow);

    expect(rows1).toHaveLength(50);
    expect(rows2).toHaveLength(25);
  });
});
