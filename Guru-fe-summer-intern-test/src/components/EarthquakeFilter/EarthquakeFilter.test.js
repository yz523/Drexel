import React from 'react';
import { shallow } from 'enzyme';

import EarthquakeFilter from './EarthquakeFilter';

describe('component - EarthquakeFilter', () => {
  it('calls handleInput on an input event with the correct value', () => {
    const mock = jest.fn();
    const comp = shallow(<EarthquakeFilter onInput={mock} />);

    comp.simulate('input', { target: { value: 'Alaska' } });

    expect(mock).toHaveBeenCalled();
  });
});
