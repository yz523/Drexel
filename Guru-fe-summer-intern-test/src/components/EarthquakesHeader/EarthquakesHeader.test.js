import React from 'react';
import { shallow } from 'enzyme';

import EarthquakesHeader from 'components/EarthquakesHeader/EarthquakesHeader';

describe('component - EarthquakesHeader', () => {
  it('Renders the columns in the correct order with the correct labels', () => {
    const comp = shallow(<EarthquakesHeader />);
    const labels = comp.find('.EarthquakesHeader__label');
    const expected = ['Id', 'Time', 'Location', 'Magnitude', 'More'];
    const recieved = Array.from(labels).map(label => label.props.children);

    expect(recieved).toEqual(expected);
  });
});
